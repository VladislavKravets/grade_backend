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

    @Column(name = "email", length = 30)
    private String email;

    @Column(name = "telephone", length = 30)
    private String telephone;

}