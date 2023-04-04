package com.example.grade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;


@Getter
@Setter
@NoArgsConstructor
public class GradeDto implements Serializable {

    private Integer grade;
    private String courseCourseNameName;
    private OffsetDateTime createdAt;

}