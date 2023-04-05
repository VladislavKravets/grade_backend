package com.example.grade.controllers;

import com.example.grade.dto.AbsenceDto;
import com.example.grade.dto.GradeDto;
import com.example.grade.models.Absence;
import com.example.grade.models.Grade;
import com.example.grade.repositories.AbsenceRepository;
import com.example.grade.repositories.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final GradeRepository gradeRepository;
    private final AbsenceRepository absenceRepository;

    @GetMapping("/getGradeByStudentId")
    public ResponseEntity getGradeByStudentId(@RequestParam("email") String email,
                                              @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                              @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Grade> grades = gradeRepository.findByStudentEmailAndCreatedAtBetween(email, startDate.atStartOfDay().atOffset(ZoneOffset.UTC), endDate.atStartOfDay().atOffset(ZoneOffset.UTC));
        ModelMapper modelMapper = new ModelMapper();
        List<GradeDto> gradeDto = grades.stream()
                .map(grade -> modelMapper.map(grade, GradeDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(gradeDto);
    }    //http://localhost:8080/api/student/getGradeByStudentId?email=u3@g&startDate=2022-01-01&endDate=2023-01-01


    @GetMapping("/getAbsenceByStudentId")
    public ResponseEntity getAbsenceByStudentId(@RequestParam("email") String email,
                                                @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)  {
//        List<Absence> absences = absenceRepository.findAllByStudentDegreeIdAndData(id, startDate.atStartOfDay().atOffset(ZoneOffset.UTC), endDate.atStartOfDay().atOffset(ZoneOffset.UTC));
        List<Absence> absences = absenceRepository.findByStudentEmailAndDataBetween(email, startDate.atStartOfDay().atOffset(ZoneOffset.UTC), endDate.atStartOfDay().atOffset(ZoneOffset.UTC));
        ModelMapper modelMapper = new ModelMapper();
        List<AbsenceDto> absenceDto = absences.stream()
                .map(absence -> modelMapper.map(absence, AbsenceDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(absenceDto);
    }    //http://localhost:8080/api/student/getAbsenceByStudentId?email=u3@g&startDate=2022-01-01&endDate=2023-01-01


}
