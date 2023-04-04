package com.example.grade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class AbsenceDto implements Serializable {
    private String courseCourseNameName;
    private OffsetDateTime data;
}