package com.example.soft_hatch.controller;

import com.example.soft_hatch.Dto.BusinessDevelopmentCoursesDto;
import com.example.soft_hatch.Dto.PortfolioCoursesDto;
import com.example.soft_hatch.Dto.Response;
import com.example.soft_hatch.entity.BusinessDevelopmentCourses;
import com.example.soft_hatch.entity.PortfolioCourses;
import com.example.soft_hatch.service.PortfolioCoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class PortfolioController {
    private final PortfolioCoursesService portfolioCoursesService;
    Response response = new Response();

    @PostMapping("/createPortfolioCourse/{id}")
    public ResponseEntity<Object> createPortfolioCourse(@RequestBody PortfolioCoursesDto portfolioCoursesDto, @PathVariable Integer id){
        try{
            response.status= Response.STATUS.Success.toString();
            response.message="Course created successfully";
            response.data= portfolioCoursesService.createPortfolioCourse(portfolioCoursesDto,id);
        }catch (Exception ex){
            ex.printStackTrace();
            response.message = "An unexpected error occurred.";
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/list_portfolio_courses")
    public List<PortfolioCourses> listAllPortfolioCourses() {
        return portfolioCoursesService.listAllPortfolioCourses();
    }
}
