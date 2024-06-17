package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.ComputerPackageDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.entity.ComputerPackage;
import com.example.soft_hatch.service.ComputerPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class PackageCourseController {
    private final ComputerPackageService computerPackageService;

    Response response = new Response();

    @PostMapping("/createComputerPackageCourse/{id}")
    public ResponseEntity<Object> createComputerPackageCourse(@RequestBody ComputerPackageDto computerPackageDto, @PathVariable Integer id){
        try{
            response.status= Response.STATUS.Success.toString();
            response.message="Course created successfully";
            response.data= computerPackageService.createComputerPackageCourse(computerPackageDto,id);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/list_package_courses")
    public List<ComputerPackage> listAllComputerPackageCourses() {
        return computerPackageService.listAllComputerPackageCourses();
    }
}
