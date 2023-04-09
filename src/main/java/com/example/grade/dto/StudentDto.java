package com.example.grade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class StudentDto implements Serializable {
    private String name;
    private String patronimic;
    private String surname;
    private String email;
}