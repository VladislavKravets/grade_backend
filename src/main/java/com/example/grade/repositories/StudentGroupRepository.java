package com.example.grade.repositories;

import com.example.grade.models.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Integer> {
    @Query("select c.studentGroup from CoursesForGroup c where c.teacher.email = ?1 and c.studentGroup.active = true")
    List<StudentGroup> findGroupByTeacherEmail(String email);
    StudentGroup findAllById(Integer id);

}