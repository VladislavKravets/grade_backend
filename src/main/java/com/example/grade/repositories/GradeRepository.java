package com.example.grade.repositories;

import com.example.grade.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    List<Grade> findAllByStudentDegreeId(Integer id);

}