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
@Table(name = "faculty")
public class Faculty {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "name_eng", length = 100)
    private String nameEng;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "abbr", nullable = false, length = 20)
    private String abbr;

    @Column(name = "dean", length = 70)
    private String dean;

    @Column(name = "dean_eng", nullable = false, length = 70)
    private String deanEng;

    @Column(name = "name_genitive", nullable = false, length = 100)
    private String nameGenitive;

}