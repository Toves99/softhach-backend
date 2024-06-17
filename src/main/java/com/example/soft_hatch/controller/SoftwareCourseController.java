package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.ComputerPackageDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.Dto.SoftwareEngineerDto;
import com.example.soft_hatch.entity.ComputerPackage;
import com.example.soft_hatch.entity.SoftwareEngineeringCourse;
import com.example.soft_hatch.service.ComputerPackageService;
import com.example.soft_hatch.service.SoftwareEngineeringCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class SoftwareCourseController {
    private final SoftwareEngineeringCourseService softwareEngineeringCourseService;
    Response response = new Response();
    @PostMapping("/createSoftwareEngineerCourse/{id}")
    public ResponseEntity<Object> createSoftwareEngineerCourse(@RequestBody SoftwareEngineerDto softwareEngineerDto, @PathVariable Integer id){
        try{
            response.status=Response.STATUS.Success.toString();
            response.message="Course created successfully";
            response.data= softwareEngineeringCourseService.createSoftwareEngineerCourse(softwareEngineerDto,id);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/list_software_courses")
    public List<SoftwareEngineeringCourse> listAllSoftwareEngineeringCourses() {
        return softwareEngineeringCourseService.listAllSoftwareEngineeringCourses();
    }



}
         