package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.DigitalAndSocialMediaCoursesDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.DigitalAndSocialMediaCourses;
import com.example.soft_hatch.service.DigitalAndSocialMediaCoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class DigitalAndSocialMediaCoursesController {
    private final DigitalAndSocialMediaCoursesService digitalAndSocialMediaCoursesService;
    Response response = new Response();

    @PostMapping("/createSocialMediaCourse/{id}")
    public ResponseEntity<Object> createSocialMediaCourse(@RequestBody DigitalAndSocialMediaCoursesDto digitalAndSocialMediaCoursesDto, @PathVariable Integer id){
        try{
            response.status= Response.STATUS.Success.toString();
            response.message="Course created successfully";
            response.data= digitalAndSocialMediaCoursesService.createSocialMediaCourse(digitalAndSocialMediaCoursesDto,id);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/list_socialmedia_courses")
    public List<DigitalAndSocialMediaCourses> listAllAccountingCourses() {
        return digitalAndSocialMediaCoursesService.listAllSocialMediaCourses();
    }
}
