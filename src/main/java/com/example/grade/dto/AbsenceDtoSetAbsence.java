package com.example.grade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceDtoSetAbsence {
    private Integer id;
    private OffsetDateTime data;
}
