package com.example.grade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class StudentGroupSmallDto implements Serializable {
    private String studentGroupId;
    private String studentGroupName;
}