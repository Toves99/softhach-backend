package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.MediaAndEntertainmentDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.MediaAndEntertainmentCourses;
import com.example.soft_hatch.service.MediaAndEntertainmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class MediaAndEntertainmentController {

    private final MediaAndEntertainmentService mediaAndEntertainmentService;
    Response response = new Response();
    @PostMapping("/createMediaCourse/{id}")
    public ResponseEntity<Object> createMediaCourse(@RequestBody MediaAndEntertainmentDto mediaAndEntertainmentDto, @PathVariable Integer id){
        try{
            response.status= Response.STATUS.Success.toString();
            response.message="Course created successfully";
            response.data= mediaAndEntertainmentService.createMediaCourse(mediaAndEntertainmentDto,id);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/list_media_courses")
    public List<MediaAndEntertainmentCourses> listAllMediaCourses() {
        return mediaAndEntertainmentService.listAllMediaCourses();
    }
}
