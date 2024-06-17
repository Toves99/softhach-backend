package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.ProgrammingLanguageDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.ProgrammingLanguage;
import com.example.soft_hatch.repository.ProgrammingLanguageRepository;
import com.example.soft_hatch.service.ProgrammingLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class ProgrammingController {
    private final ProgrammingLanguageService programmingLanguageService;
    Response response = new Response();
    @PostMapping("/createProgrammingCourse/{id}")
    public ResponseEntity<Object> createProgrammingCourse(@RequestBody ProgrammingLanguageDto programmingLanguageDto, @PathVariable Integer id){
        try{
            response.status= Response.STATUS.Success.toString();
            response.message="Course created successfully";
            response.data= programmingLanguageService.createProgrammingCourse(programmingLanguageDto,id);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/list_programming_courses")
    public List<ProgrammingLanguage> listAllProgrammingCourses() {
        return programmingLanguageService.listAllProgrammingCourses();
    }
}
