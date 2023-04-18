package com.example.grade.repositories;

import com.example.grade.models.StudentGroup;
import com.example.grade.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Optional<Teacher> findByEmail(String email);


    @Query(value="     SELECT 'student' AS table_name" +
            "    FROM student" +
            "    WHERE email = :email" +
            "    UNION ALL" +
            "    SELECT 'teacher' AS table_name" +
            "    FROM teacher" +
            "    WHERE email = :email", nativeQuery = true)
    String findTeacherOrStudentByEmail(@Param("email") String email);

}