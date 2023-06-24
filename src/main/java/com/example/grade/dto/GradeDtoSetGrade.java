package com.example.grade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GradeDtoSetGrade {
    private Integer id;
    private Integer grade;
    private OffsetDateTime createdAt;
}
