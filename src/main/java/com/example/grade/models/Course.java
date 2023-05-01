package com.example.grade.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "credits", nullable = false, precision = 5, scale = 2)
    private BigDecimal credits;

    @Column(name = "hours", nullable = false)
    private Integer hours;

    @Column(name = "hours_per_credit", nullable = false)
    private Integer hoursPerCredit;

    @Column(name = "semester", nullable = false)
    private Integer semester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_name_id")
    private CourseName courseName;

}