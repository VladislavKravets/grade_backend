package com.example.grade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class TeacherDto implements Serializable {
    private String name;
    private String patronimic;
    private String sex;
    private String surname;
    private Boolean active;
    private String departmentName;
    private String departmentFacultyName;
    private String positionName;
    private String scientificDegreeName;

}