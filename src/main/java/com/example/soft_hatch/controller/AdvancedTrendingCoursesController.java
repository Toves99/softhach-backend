package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.AdvancedTrendingCoursesDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.AdvancedTrendingCourses;
import com.example.soft_hatch.service.AdvancedTrendingCoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AdvancedTrendingCoursesController {
    private final AdvancedTrendingCoursesService advancedTrendingCoursesService;
    Response response = new Response();

    @PostMapping("/createTrendingCourse/{id}")
    public ResponseEntity<Object> createTrendingCourse(@RequestBody AdvancedTrendingCoursesDto advancedTrendingCoursesDto, @PathVariable Integer id){
        try{
            response.status= Response.STATUS.Success.toString();
            response.message="Course created successfully";
            response.data= advancedTrendingCoursesService.createTrendingCourse(advancedTrendingCoursesDto,id);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/list_trending_courses")
    public List<AdvancedTrendingCourses> listAllTrendingCourses() {
        return advancedTrendingCoursesService.listAllTrendingCourses();
    }
}
