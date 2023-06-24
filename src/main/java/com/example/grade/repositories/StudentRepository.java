package com.example.grade.repositories;

import com.example.grade.models.Course;
import com.example.grade.models.CourseName;
import com.example.grade.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
