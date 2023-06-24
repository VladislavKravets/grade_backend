package com.example.grade.repositories;

import com.example.grade.models.Course;
import com.example.grade.models.CourseName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseNameRepository extends JpaRepository<CourseName, Integer> {
}