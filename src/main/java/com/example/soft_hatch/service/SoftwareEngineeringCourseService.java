package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.SoftwareEngineerDto;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.entity.SoftwareEngineeringCourse;
import com.example.soft_hatch.repository.CourseRepository;
import com.example.soft_hatch.repository.SoftwareEngineeringCourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SoftwareEngineeringCourseService {
    private final CourseRepository courseRepository;
    private final SoftwareEngineeringCourseRepository softwareEngineeringCourseRepository;

    public SoftwareEngineerDto createSoftwareEngineerCourse(SoftwareEngineerDto softwareEngineerDto,Integer id){
        Courses courses=courseRepository.getById(id);
        var software= SoftwareEngineeringCourse.builder().build();
        software.setCourses(courses);
        softwareEngineeringCourseRepository.save(software);
        return SoftwareEngineerDto.builder().build();
    }
    public List<SoftwareEngineeringCourse> listAllSoftwareEngineeringCourses() {
        return softwareEngineeringCourseRepository.findAll();
    }
}
