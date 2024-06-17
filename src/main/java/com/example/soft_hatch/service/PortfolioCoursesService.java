package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.PortfolioCoursesDto;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.entity.PortfolioCourses;
import com.example.soft_hatch.repository.CourseRepository;
import com.example.soft_hatch.repository.PortfolioCoursesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PortfolioCoursesService {
    private final CourseRepository courseRepository;
    private final PortfolioCoursesRepository portfolioCoursesRepository;

    public PortfolioCoursesDto createPortfolioCourse(PortfolioCoursesDto portfolioCoursesDto, Integer id) {
        Courses courses = courseRepository.getById(id);
        var portfolioCourses = PortfolioCourses.builder().build();
        portfolioCourses.setCourses(courses);
        portfolioCoursesRepository.save(portfolioCourses);
        return PortfolioCoursesDto.builder().build();
    }
    public List<PortfolioCourses> listAllPortfolioCourses() {
        return portfolioCoursesRepository.findAll();
    }
}
