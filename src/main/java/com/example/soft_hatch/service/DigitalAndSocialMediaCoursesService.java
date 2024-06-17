package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.DigitalAndSocialMediaCoursesDto;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.entity.DigitalAndSocialMediaCourses;
import com.example.soft_hatch.repository.CourseRepository;
import com.example.soft_hatch.repository.DigitalAndSocialMediaCoursesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DigitalAndSocialMediaCoursesService {
    private final CourseRepository courseRepository;
    private final DigitalAndSocialMediaCoursesRepository digitalAndSocialMediaCoursesRepository;

    public DigitalAndSocialMediaCoursesDto createSocialMediaCourse(DigitalAndSocialMediaCoursesDto digitalAndSocialMediaCoursesDto, Integer id) {
        Courses courses = courseRepository.getById(id);
        var digitalAndSocialMediaCourses = DigitalAndSocialMediaCourses.builder().build();
        digitalAndSocialMediaCourses.setCourses(courses);
        digitalAndSocialMediaCoursesRepository.save(digitalAndSocialMediaCourses);
        return DigitalAndSocialMediaCoursesDto.builder().build();
    }

    public List<DigitalAndSocialMediaCourses> listAllSocialMediaCourses() {
        return digitalAndSocialMediaCoursesRepository.findAll();
    }
}
