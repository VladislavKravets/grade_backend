package com.example.grade.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "student_group")
public class StudentGroup {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "begin_years", nullable = false)
    private Integer beginYears;

    @Column(name = "creation_year", nullable = false)
    private Integer creationYear;

    @Column(name = "study_semesters", nullable = false)
    private Integer studySemesters;

    @Column(name = "study_years", nullable = false, precision = 19, scale = 2)
    private BigDecimal studyYears;

    @Column(name = "tuition_form", nullable = false, length = 10)
    private String tuitionForm;

    @Column(name = "tuition_term", nullable = false, length = 10)
    private String tuitionTerm;

    @Column(name = "specialization_id", nullable = false)
    private Integer specializationId;

    @Column(name = "real_begin_year", nullable = false)
    private Integer realBeginYear;

}