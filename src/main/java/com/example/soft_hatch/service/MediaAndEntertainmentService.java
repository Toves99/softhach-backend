package com.example.soft_hatch.service;

import com.example.soft_hatch.Dto.AccountingCoursesDto;
import com.example.soft_hatch.Dto.MediaAndEntertainmentDto;
import com.example.soft_hatch.entity.AccountingCourses;
import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.entity.MediaAndEntertainmentCourses;
import com.example.soft_hatch.repository.CourseRepository;
import com.example.soft_hatch.repository.MediaAndEntertainmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaAndEntertainmentService {
    private final CourseRepository courseRepository;
    private final MediaAndEntertainmentRepository mediaAndEntertainmentRepository;

    public MediaAndEntertainmentDto createMediaCourse(MediaAndEntertainmentDto mediaAndEntertainmentDto, Integer id) {
        Courses courses = courseRepository.getById(id);
        var mediaAndEntertainmentCourses = MediaAndEntertainmentCourses.builder().build();
        mediaAndEntertainmentCourses.setCourses(courses);
        mediaAndEntertainmentRepository.save(mediaAndEntertainmentCourses);
        return  MediaAndEntertainmentDto.builder().build();
    }
    public List<MediaAndEntertainmentCourses> listAllMediaCourses() {
        return mediaAndEntertainmentRepository.findAll();
    }
}
