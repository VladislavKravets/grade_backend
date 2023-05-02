package com.example.grade.repositories;

import com.example.grade.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
    @Query("select a from Absence a where a.studentDegree.student.email = ?1 and a.data between ?2 and ?3")
    List<Absence> findByStudentEmailAndDataBetween(String email, OffsetDateTime dataStart, OffsetDateTime dataEnd);
}