package com.example.soft_hatch.repository;

import com.example.soft_hatch.entity.Courses;
import com.example.soft_hatch.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Courses,Integer> {
}
