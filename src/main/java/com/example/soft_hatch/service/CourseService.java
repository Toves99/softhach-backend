package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.CourseDto;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;


    public CourseDto createCourse(CourseDto courseDto){
        var course= Courses.builder()
                .title(courseDto.getTitle())
                .course_description(courseDto.getCourse_description())
                .course_duration(courseDto.getCourse_duration())
                .cost(courseDto.getCost())
                .created_at(ZonedDateTime.now())
                .build();
        courseRepository.save(course);
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .course_description(course.getCourse_description())
                .course_duration(course.getCourse_duration())
                .cost(course.getCost())
                .created_at(course.getCreated_at())
                .build();

    }
    public Optional<Courses> getCourseById(Integer id) {
        return courseRepository .findById(id);
    }
    public List<Courses> listAll() {
        List<Courses> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }
    public void deleteCourseById(Integer id) {
        courseRepository.deleteById(id);
    }

}
