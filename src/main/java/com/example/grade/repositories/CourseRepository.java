package com.example.grade.repositories;

import com.example.grade.models.Course;
import com.example.grade.models.CourseName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findByCourseName(CourseName courseName);
    Optional<Course> findByCourseNameAndSemester(CourseName courseName, int semester);

}