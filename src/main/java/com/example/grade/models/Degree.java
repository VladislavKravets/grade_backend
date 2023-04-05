package com.example.grade.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "degree")
public class Degree {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "name_eng", nullable = false, length = 100)
    private String nameEng;

    @Column(name = "admission_requirements", nullable = false, length = 300)
    private String admissionRequirements;

    @Column(name = "admission_requirements_eng", nullable = false, length = 300)
    private String admissionRequirementsEng;

    @Column(name = "further_study_access", nullable = false)
    private String furtherStudyAccess;

    @Column(name = "further_study_access_eng", nullable = false)
    private String furtherStudyAccessEng;

    @Column(name = "qualification_level_descr", nullable = false, length = 500)
    private String qualificationLevelDescr;

    @Column(name = "qualification_level_descr_eng", nullable = false, length = 500)
    private String qualificationLevelDescrEng;

    @Column(name = "admission_foreign_requirements", nullable = false, length = 300)
    private String admissionForeignRequirements;

    @Column(name = "admission_foreign_requirements_eng", nullable = false, length = 300)
    private String admissionForeignRequirementsEng;

}