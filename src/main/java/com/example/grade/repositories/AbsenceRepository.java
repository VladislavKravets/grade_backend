package com.example.grade.repositories;

import com.example.grade.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
    List<Absence> findAllByStudentDegreeId(Integer id);
    @Query("SELECT a FROM Absence a WHERE a.studentDegree.id = :id AND a.data >= :startDate AND a.data < :endDate")
    List<Absence> findAllByStudentDegreeIdAndData(@Param("id") Integer id,

                                                  @Param("startDate") OffsetDateTime startDate,
                                                  @Param("endDate") OffsetDateTime endDate);
}