package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.AdvancedTrendingCoursesDto;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.AdvancedTrendingCourses;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.repository.AdvancedTrendingCoursesRepository;
import com.example.soft_hatch.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvancedTrendingCoursesService {
    private final CourseRepository courseRepository;
    private final AdvancedTrendingCoursesRepository advancedTrendingCoursesRepository;

    public AdvancedTrendingCoursesDto createTrendingCourse(AdvancedTrendingCoursesDto advancedTrendingCoursesDto, Integer id) {
        Courses courses = courseRepository.getById(id);
        var advancedTrendingCourses = AdvancedTrendingCourses.builder().build();
        advancedTrendingCourses.setCourses(courses);
        advancedTrendingCoursesRepository.save(advancedTrendingCourses);
        return AdvancedTrendingCoursesDto.builder().build();
    }
    public List<AdvancedTrendingCourses> listAllTrendingCourses() {
        return advancedTrendingCoursesRepository.findAll();
    }
}
