package com.example.grade.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "student_degree")
public class StudentDegree {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "admission_date")
    private LocalDate admissionDate;

    @Column(name = "admission_order_date")
    private LocalDate admissionOrderDate;

    @Column(name = "admission_order_number", length = 15)
    private String admissionOrderNumber;

    @Column(name = "contract_date")
    private LocalDate contractDate;

    @Column(name = "contract_number", length = 15)
    private String contractNumber;

    @Column(name = "diploma_date")
    private LocalDate diplomaDate;

    @Column(name = "diploma_number", length = 15)
    private String diplomaNumber;

    @Column(name = "payment", nullable = false, length = 8)
    private String payment;

    @Column(name = "previous_diploma_date")
    private LocalDate previousDiplomaDate;

    @Column(name = "previous_diploma_issued_by")
    private String previousDiplomaIssuedBy;

    @Column(name = "previous_diploma_issued_by_eng")
    private String previousDiplomaIssuedByEng;

    @Column(name = "previous_diploma_number", length = 15)
    private String previousDiplomaNumber;

    @Column(name = "previous_diploma_type", nullable = false, length = 30)
    private String previousDiplomaType;

    @Column(name = "protocol_date")
    private LocalDate protocolDate;

    @Column(name = "protocol_number", length = 10)
    private String protocolNumber;

    @Column(name = "record_book_number", length = 15)
    private String recordBookNumber;

    @Column(name = "student_card_number", length = 15)
    private String studentCardNumber;

    @Column(name = "supplement_date")
    private LocalDate supplementDate;

    @Column(name = "supplement_number", length = 15)
    private String supplementNumber;

    @Column(name = "thesis_name", length = 250)
    private String thesisName;

    @Column(name = "thesis_name_eng", length = 250)
    private String thesisNameEng;

    @Column(name = "specialization_id", nullable = false)
    private Integer specializationId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_group_id")
    private StudentGroup studentGroup;

    @Column(name = "diploma_with_honours", nullable = false)
    private Boolean diplomaWithHonours = false;

    @Column(name = "thesis_supervisor", length = 120)
    private String thesisSupervisor;

    @Column(name = "citizenship", nullable = false, length = 3)
    private String citizenship;

    @Column(name = "tuition_form", nullable = false, length = 10)
    private String tuitionForm;

    @Column(name = "tuition_term", nullable = false, length = 10)
    private String tuitionTerm;

    @Column(name = "edebo_id", length = 15)
    private String edeboId;

}