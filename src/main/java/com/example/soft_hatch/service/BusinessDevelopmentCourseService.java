package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.BusinessDevelopmentCoursesDto;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.BusinessDevelopmentCourses;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.repository.BusinessDevelopmentRepository;
import com.example.soft_hatch.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BusinessDevelopmentCourseService {

    private final CourseRepository courseRepository;
    private final BusinessDevelopmentRepository businessDevelopmentRepository;

    public BusinessDevelopmentCoursesDto createBusinessCourse(BusinessDevelopmentCoursesDto businessDevelopmentCoursesDto, Integer id) {
        Courses courses = courseRepository.getById(id);
        var businessDevelopmentCourses = BusinessDevelopmentCourses.builder().build();
        businessDevelopmentCourses.setCourses(courses);
        businessDevelopmentRepository.save(businessDevelopmentCourses);
        return BusinessDevelopmentCoursesDto.builder().build();

    }

    public List<BusinessDevelopmentCourses> listAllBusinessCourses() {
        return businessDevelopmentRepository.findAll();
    }

}
