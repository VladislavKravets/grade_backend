package com.example.grade.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "ects", length = 2)
    private String ects;

    @Column(name = "grade")
    private Integer grade;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "student_degree_id", nullable = false)
    private StudentDegree studentDegree;

    @Column(name = "academic_difference", nullable = false)
    private Boolean academicDifference = false;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

}