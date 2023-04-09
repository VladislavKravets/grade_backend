package com.example.grade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class StudentGroupDto implements Serializable {
    private String name;
    private Boolean active;
    private Integer beginYears;
    private Integer creationYear;
    private Integer studySemesters;
    private BigDecimal studyYears;
    private String specializationName;
    private String specializationDegreeName;
    private String specializationDepartmentName;
    private String specializationFacultyName;
    private String specializationSpecialityName;
    private String specializationProgramHeadName;
    private String specializationProgramHeadPatronimic;
    private String specializationProgramHeadSurname;
}