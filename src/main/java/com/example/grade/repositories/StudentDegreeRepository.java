package com.example.grade.repositories;

import com.example.grade.models.Student;
import com.example.grade.models.StudentDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDegreeRepository extends JpaRepository<StudentDegree, Integer> {
    @Query("select s.student from StudentDegree s where s.studentGroup.id = ?1 and s.active = true")
    List<Student> findStudentByStudentGroupId(Integer id);
    StudentDegree findAllByStudentEmail(String email);

}