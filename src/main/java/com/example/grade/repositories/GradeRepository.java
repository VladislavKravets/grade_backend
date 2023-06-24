package com.example.grade.repositories;

import com.example.grade.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.OffsetDateTime;
import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    @Query("select g from Grade g where g.studentDegree.student.email = ?1 and g.createdAt between ?2 and ?3")
    List<Grade> findByStudentEmailAndCreatedAtBetween(String email, OffsetDateTime createdAtStart, OffsetDateTime createdAtEnd);

    Grade save(Grade grade);

//    @Modifying
//    @Query("INSERT INTO Grade (grade, course, studentDegree, date) " +
//            "SELECT :grade, c, sd " +
//            "FROM Course c, StudentDegree sd " +
//            "WHERE c.id = :courseId AND sd.student.id = :studentId")
//    void insertGrade(Long courseId, int grade, Long studentId, OffsetDateTime date);
}