package com.example.grade.repositories;

import com.example.grade.models.CoursesForGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoursesForGroupRepository extends JpaRepository<CoursesForGroup, Integer> {


    @Query("select c from CoursesForGroup c where c.studentGroup.name = ?1")
    CoursesForGroup findByStudentGroup_Name(String name);

}