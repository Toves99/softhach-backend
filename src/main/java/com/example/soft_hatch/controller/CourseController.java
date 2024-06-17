package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.CourseDto;
import com.example.soft_hatch.Dto.RegisterDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    Response response = new Response();

    @PostMapping("/createCourse")
    public ResponseEntity<Object> createCourse(@RequestBody CourseDto courseDto){

        try{
            if(courseDto.getTitle()==null||courseDto.getCourse_description()==null||courseDto.getCourse_duration()==null||courseDto.getCost()==null){
                response.status=Response.STATUS.Failed.toString();
                response.message="Please enter mandatory fields[title,description,duration,cost].";
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            response.status=Response.STATUS.Success.toString();
            response.message = "Course created successfully.";
            response.data = courseService.createCourse(courseDto);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/getCourseById/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable Integer id) {
        try {
            Optional<Courses> course = courseService.getCourseById(id);
            if (course.isPresent()) {
                return new ResponseEntity<>(course.get(), HttpStatus.OK);
            } else {
                response.status = Response.STATUS.Failed.toString();
                response.message = "Course not found.";
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An error occurred while fetching the course.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<Object> deleteCourseById(@PathVariable Integer id) {
        try {
            Optional<Courses> user = courseService.getCourseById(id);
            if (user.isPresent()) {
                courseService.deleteCourseById(id);
                response.status = Response.STATUS.Success.toString();
                response.message = "Course deleted successfully.";
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.status = Response.STATUS.Failed.toString();
                response.message = "Course not found.";
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An error occurred while deleting the course.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/listAllCourses")
    public ResponseEntity<Object> listAllCourses() {
        try {
            List<Courses> courses = courseService.listAll();
            response.status = Response.STATUS.Success.toString();
            response.message="course listed";
            response.data = courses;
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.status = Response.STATUS.Failed.toString();
            response.message = "An error occurred while fetching the courses.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
