package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.AuthDto;
import com.example.soft_hatch.Dto.LoginDto;
import com.example.soft_hatch.Dto.RegisterDto;
import com.example.soft_hatch.config.JwtService;
import com.example.soft_hatch.entity.User;
import com.example.soft_hatch.enums.Role;
import com.example.soft_hatch.repository.TokenRepository;
import com.example.soft_hatch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;

    public AuthDto register(RegisterDto registerDto){
        var user= User.builder()
                .first_name(registerDto.getFirst_name())
                .last_name(registerDto.getLast_name())
                .phone_number(registerDto.getPhone_number())
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .created_at(ZonedDateTime.now())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthDto.builder()
                .id(user.getId())
                .token(jwtToken)
                .build();
    }

    public AuthDto authenticate(LoginDto loginDto){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        var user=userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);

        return AuthDto.builder()
                .id(user.getId())
                .token(jwtToken)
                .build();
    }
    public boolean isEmailExist(String email) {
        if(email==null)
            return false;
        Optional<User> m = userRepository.findByEmail(email);
        return m.isPresent();
    }
}
