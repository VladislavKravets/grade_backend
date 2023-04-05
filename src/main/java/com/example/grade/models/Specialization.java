package com.example.grade.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "specialization")
public class Specialization {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "name_eng", length = 100)
    private String nameEng;

    @Column(name = "code", length = 15)
    private String code;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "certificate_date")
    private LocalDate certificateDate;

    @Column(name = "certificate_number", length = 20)
    private String certificateNumber;

    @Column(name = "payment_extramural", precision = 15, scale = 2)
    private BigDecimal paymentExtramural;

    @Column(name = "payment_fulltime", precision = 15, scale = 2)
    private BigDecimal paymentFulltime;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "degree_id", nullable = false)
    private Degree degree;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "program_head_id")
    private Teacher programHead;

    @Column(name = "certificate_issued_by", nullable = false, length = 100)
    private String certificateIssuedBy;

    @Column(name = "certificate_issued_by_eng", nullable = false, length = 100)
    private String certificateIssuedByEng;

    @Column(name = "specialization_name", length = 100)
    private String specializationName;

    @Column(name = "specialization_name_eng", length = 100)
    private String specializationNameEng;

    @Column(name = "normative_credits_number", nullable = false)
    private Integer normativeCreditsNumber;

    @Column(name = "normative_term_of_study", nullable = false, precision = 10, scale = 2)
    private BigDecimal normativeTermOfStudy;

}