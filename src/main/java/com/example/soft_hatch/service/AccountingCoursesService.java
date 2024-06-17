package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.repository.AccountingCourseRepository;
import com.example.soft_hatch.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountingCoursesService {
    private final CourseRepository courseRepository;
    private final AccountingCourseRepository accountingCourseRepository;

    public AccountingCoursesDto createAccountingCourse(AccountingCoursesDto accountingCoursesDto, Integer id) {
        Courses courses = courseRepository.getById(id);
        var accountingCourses = AccountingCourses.builder().build();
        accountingCourses.setCourses(courses);
        accountingCourseRepository.save(accountingCourses);
        return AccountingCoursesDto.builder().build();
    }

    public List<AccountingCourses> listAllAccountingCourses() {
        return accountingCourseRepository.findAll();
    }

}
