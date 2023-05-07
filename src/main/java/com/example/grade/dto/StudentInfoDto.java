package com.example.grade.dto;

import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class StudentInfoDto implements Serializable {
    private String specializationName;
    private Integer studentId;
    private String studentName;
    private String studentPatronimic;
    private String studentSex;
    private String studentSurname;
    private String studentEmail;
    private String studentTelephone;
    private Integer studentGroupId;
    private String studentGroupName;
}