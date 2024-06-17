package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.AuthDto;
import com.example.soft_hatch.Dto.LoginDto;
import com.example.soft_hatch.Dto.RegisterDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    Response response=new Response();

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterDto registerDto){

        try{
            if(registerDto.getFirst_name()==null||registerDto.getLast_name()==null||registerDto.getPhone_number()==null||registerDto.getEmail()==null||registerDto.getPassword()==null){
                response.status=Response.STATUS.Failed.toString();
                response.message="Please enter mandatory fields[firstName,lastName,phoneNumber,email,username,password].";
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else if (authService.isEmailExist(registerDto.getEmail())) {
                response.status = Response.STATUS.Failed.toString();
                response.message = "Email already exists.";
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.status=Response.STATUS.Success.toString();
            response.message = "User registered successfully.";
            response.data = authService.register(registerDto);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(
            @RequestBody LoginDto loginDto
    ){
        try{
            if(loginDto.getEmail()==null||loginDto.getPassword()==null){
                response.status=Response.STATUS.Failed.toString();
                response.message="Please enter mandatory fields[email,password].";
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.status=Response.STATUS.Success.toString();
            response.message = "User LoggedIn successfully.";
            response.data = authService.authenticate(loginDto);
        }catch (AuthenticationException ex) {
            response.status = Response.STATUS.Failed.toString();
            response.message = "Invalid credentials.";
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
