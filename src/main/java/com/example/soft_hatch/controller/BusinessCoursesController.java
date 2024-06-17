package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.BusinessDevelopmentCoursesDto;
import com.example.soft_hatch.Dto.MediaAndEntertainmentDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.entity.BusinessDevelopmentCourses;
import com.example.soft_hatch.entity.MediaAndEntertainmentCourses;
import com.example.soft_hatch.service.BusinessDevelopmentCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class BusinessCoursesController {
    private final BusinessDevelopmentCourseService businessDevelopmentCourseService;
    Response response = new Response();

    @PostMapping("/createBusinessCourse/{id}")
    public ResponseEntity<Object> createBusinessCourse(@RequestBody BusinessDevelopmentCoursesDto businessDevelopmentCoursesDto, @PathVariable Integer id){
        try{
            response.status= Response.STATUS.Success.toString();
            response.message="Course created successfully";
            response.data= businessDevelopmentCourseService.createBusinessCourse(businessDevelopmentCoursesDto,id);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/list_business_courses")
    public List<BusinessDevelopmentCourses> listAllBusinessCourses() {
        return businessDevelopmentCourseService.listAllBusinessCourses();
    }
}
