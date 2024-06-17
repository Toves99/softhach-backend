package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.ProgrammingLanguageDto;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.entity.ProgrammingLanguage;
import com.example.soft_hatch.repository.CourseRepository;
import com.example.soft_hatch.repository.ProgrammingLanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgrammingLanguageService {
    private final CourseRepository courseRepository;
    private final ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageDto createProgrammingCourse(ProgrammingLanguageDto programmingLanguageDto, Integer id) {
        Courses courses = courseRepository.getById(id);
        var programmingLanguage = ProgrammingLanguage.builder().build();
        programmingLanguage.setCourses(courses);
        programmingLanguageRepository.save(programmingLanguage);
        return ProgrammingLanguageDto.builder().build();
    }
    public List<ProgrammingLanguage> listAllProgrammingCourses() {
        return programmingLanguageRepository.findAll();
    }
}
