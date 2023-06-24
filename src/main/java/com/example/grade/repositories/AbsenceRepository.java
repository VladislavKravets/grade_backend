package com.example.grade.repositories;

import com.example.grade.models.Absence;
import com.example.grade.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
    @Query("select a from Absence a where a.studentDegree.student.email = ?1 and a.data between ?2 and ?3")
    List<Absence> findByStudentEmailAndDataBetween(String email, OffsetDateTime dataStart, OffsetDateTime dataEnd);
    @Query("SELECT a FROM Absence a WHERE a.data = :date and a.studentDegree.id = :studentId and a.course.id = :courseId")
    Absence findByDate(@Param("studentId") int studentId,
                       @Param("courseId") int courseId,
                       @Param("date") OffsetDateTime date);
    Absence save(Absence absence);

}