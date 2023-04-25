package com.example.grade.dto;

import com.example.grade.models.CoursesForGroup;
import lombok.Data;

import java.io.Serializable;

@Data
public class CoursesForGroupDto implements Serializable {
    private String courseCourseNameId;
    private String courseCourseNameName;
}