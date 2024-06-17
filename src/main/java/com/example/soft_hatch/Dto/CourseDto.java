package com.example.soft_hatch.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Integer id;
    private String title;
    private String course_description;
    private String course_duration;
    private String cost;
    private ZonedDateTime created_at;
    private ZonedDateTime updated_at;
}
