package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.ComputerPackageDto;
import com.example.soft_hatch.entity.ComputerPackage;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.entity.SoftwareEngineeringCourse;
import com.example.soft_hatch.repository.ComputerPackageRepository;
import com.example.soft_hatch.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComputerPackageService {
    private final CourseRepository courseRepository;
    private final ComputerPackageRepository computerPackageRepository;


    public ComputerPackageDto createComputerPackageCourse(ComputerPackageDto computerPackageDto,Integer id) {
        Courses courses = courseRepository.getById(id);
        var computerPackage = ComputerPackage.builder().build();
        computerPackage.setCourses(courses);
        computerPackageRepository.save(computerPackage);
        return ComputerPackageDto.builder().build();
    }
    public List<ComputerPackage> listAllComputerPackageCourses() {
        return computerPackageRepository.findAll();
    }


    }
