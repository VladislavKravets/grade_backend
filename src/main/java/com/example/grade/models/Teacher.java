package com.example.grade.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "patronimic", length = 20)
    private String patronimic;

    @Column(name = "sex", nullable = false, length = 6)
    private String sex;

    @Column(name = "surname", nullable = false, length = 20)
    private String surname;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @Column(name = "academic_title", length = 25)
    private String academicTitle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "scientific_degree_id")
    private ScientificDegree scientificDegree;

}