package com.example.grade.controllers;

import com.example.grade.dto.AbsenceDto;
import com.example.grade.dto.GradeDto;
import com.example.grade.dto.StudentInfoDto;
import com.example.grade.models.Absence;
import com.example.grade.models.Grade;
import com.example.grade.models.StudentDegree;
import com.example.grade.repositories.AbsenceRepository;
import com.example.grade.repositories.CoursesForGroupRepository;
import com.example.grade.repositories.GradeRepository;
import com.example.grade.repositories.StudentDegreeRepository;
import io.swagger.v3.oas.annotations.Operation;
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
    private final StudentDegreeRepository studentDegreeRepository;
    private final CoursesForGroupRepository coursesForGroupRepository;

    @Operation(summary = "Приймає email і діапазон дати і повертає всі оцінки студента.")
    @GetMapping("/getGradesByStudentEmail")
    public ResponseEntity getGradesByStudentEmail(@RequestParam("email") String email,
                                              @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                              @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<Grade> grades = gradeRepository.findByStudentEmailAndCreatedAtBetween(email, startDate.atStartOfDay().atOffset(ZoneOffset.UTC), endDate.atStartOfDay().atOffset(ZoneOffset.UTC));
        ModelMapper modelMapper = new ModelMapper();
        List<GradeDto> gradeDto = grades.stream()
                .map(grade -> modelMapper.map(grade, GradeDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(gradeDto);
    }    //http://localhost:8080/api/student/getGradesByStudentEmail?email=s30001@g&startDate=2022-01-01&endDate=2023-01-01

    @Operation(summary = "Приймає email і діапазон дати і повертає всі пропуски студента.")
    @GetMapping("/getAbsencesByStudentEmail")
    public ResponseEntity getAbsencesByStudentEmail(@RequestParam("email") String email,
                                                @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate)  {
        List<Absence> absences = absenceRepository.findByStudentEmailAndDataBetween(email, startDate.atStartOfDay().atOffset(ZoneOffset.UTC), endDate.atStartOfDay().atOffset(ZoneOffset.UTC));
        ModelMapper modelMapper = new ModelMapper();
        List<AbsenceDto> absenceDto = absences.stream()
                .map(absence -> modelMapper.map(absence, AbsenceDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(absenceDto);
    }    //http://localhost:8080/api/student/getAbsencesByStudentEmail?email=s30001@g&startDate=2022-01-01&endDate=2023-01-01

    @Operation(summary = "Приймає email студента і повертає інформацію про нього.")
    @GetMapping("/getStudentInfoByEmail")
    public ResponseEntity getStudentInfoByEmail(@RequestParam("email") String email) {
        StudentDegree student = studentDegreeRepository.findAllByStudentEmail(email);
        ModelMapper modelMapper = new ModelMapper();
        return ResponseEntity.ok(modelMapper.map(student, StudentInfoDto.class));
    }    //http://localhost:8080/api/student/getStudentInfoByEmail?email=s30006@g

    @Operation(summary = "Приймає email студента і семестре і повертає список предметів.")
    @GetMapping("/getByStudentEmailAndCourseSemester")
    public ResponseEntity getByStudentEmailAndCourseSemester(@RequestParam("email") String email,
                                                             @RequestParam("semester") Integer semester) {
        List<String> courses = coursesForGroupRepository.findByStudentEmailAndCourseSemester(email, semester);
        ModelMapper modelMapper = new ModelMapper();
        return ResponseEntity.ok(courses);
    }//http://localhost:8080/api/student/getByStudentEmailAndCourseSemester?email=s30006@g&semester=5
}
