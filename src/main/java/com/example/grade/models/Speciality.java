package com.example.grade.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "speciality")
public class Speciality {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "name_eng", length = 100)
    private String nameEng;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @Column(name = "field_of_study", length = 150)
    private String fieldOfStudy;

    @Column(name = "field_of_study_code", length = 20)
    private String fieldOfStudyCode;

    @Column(name = "field_of_study_eng", length = 150)
    private String fieldOfStudyEng;

    @Column(name = "name_genitive", nullable = false, length = 100)
    private String nameGenitive;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "field_of_knowledge_id", nullable = false)
    private FieldOfKnowledge fieldOfKnowledge;

    @Column(name = "name_international", nullable = false, length = 100)
    private String nameInternational;

    @Column(name = "regulated_profession_access", nullable = false, length = 120)
    private String regulatedProfessionAccess;

    @Column(name = "regulated_profession_access_eng", nullable = false, length = 120)
    private String regulatedProfessionAccessEng;

    @Column(name = "entrance_certificates", nullable = false, length = 150)
    private String entranceCertificates;

    @Column(name = "entrance_certificates_eng", nullable = false, length = 150)
    private String entranceCertificatesEng;

}