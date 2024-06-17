package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.ComputerPackageDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.ComputerPackage;
import com.example.soft_hatch.service.AccountingCoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AccountingController {
    private final AccountingCoursesService accountingCoursesService;
    Response response = new Response();


    @PostMapping("/createAccountingCourse/{id}")
    public ResponseEntity<Object> createAccountingCourse(@RequestBody AccountingCoursesDto accountingCoursesDto, @PathVariable Integer id){
        try{
            response.status= Response.STATUS.Success.toString();
            response.message="Course created successfully";
            response.data= accountingCoursesService.createAccountingCourse(accountingCoursesDto,id);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/list_accounting_courses")
    public List<AccountingCourses> listAllAccountingCourses() {
        return accountingCoursesService.listAllAccountingCourses();
    }
}
