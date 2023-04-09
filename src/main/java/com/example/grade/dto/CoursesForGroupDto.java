package com.example.grade.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CoursesForGroupDto implements Serializable {
    private String studentGroupName;
}