package com.example.grade.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "patronimic", length = 25)
    private String patronimic;

    @Column(name = "sex", nullable = false, length = 6)
    private String sex;

    @Column(name = "surname", nullable = false, length = 25)
    private String surname;

    @Column(name = "actual_address", length = 100)
    private String actualAddress;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "father_info", length = 70)
    private String fatherInfo;

    @Column(name = "father_name", length = 40)
    private String fatherName;

    @Column(name = "father_phone", length = 20)
    private String fatherPhone;

    @Column(name = "mother_info", length = 70)
    private String motherInfo;

    @Column(name = "mother_name", length = 40)
    private String motherName;

    @Column(name = "mother_phone", length = 20)
    private String motherPhone;

    @Column(name = "name_eng", length = 25)
    private String nameEng;

    @Column(name = "notes", length = 150)
    private String notes;

    @Column(name = "patronimic_eng", length = 25)
    private String patronimicEng;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "registration_address", length = 100)
    private String registrationAddress;

    @Column(name = "school")
    private String school;

    @Column(name = "surname_eng", length = 25)
    private String surnameEng;

    @Column(name = "telephone", length = 30)
    private String telephone;

    @Column(name = "privilege_id")
    private Integer privilegeId;

}