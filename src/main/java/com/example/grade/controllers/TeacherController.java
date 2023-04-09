package com.example.grade.controllers;

import com.example.grade.dto.StudentDto;
import com.example.grade.dto.StudentGroupDto;
import com.example.grade.dto.StudentGroupSmallDto;
import com.example.grade.dto.TeacherDto;
import com.example.grade.models.Student;
import com.example.grade.models.StudentGroup;
import com.example.grade.models.Teacher;
import com.example.grade.repositories.StudentDegreeRepository;
import com.example.grade.repositories.StudentGroupRepository;
import com.example.grade.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherRepository teacherRepository;
    private final StudentDegreeRepository studentDegreeRepository;
    private final StudentGroupRepository studentGroupRepository;
    @GetMapping("/getTeacherInfoByEmail")
    public ResponseEntity getTeacherInfoByEmail(@RequestParam("email") String email) {
        Teacher teacher = teacherRepository.findByEmail(email).get();
        ModelMapper modelMapper = new ModelMapper();
        return ResponseEntity.ok(modelMapper.map(teacher, TeacherDto.class));
    }    //http://localhost:8080/api/teacher/getTeacherInfoByEmail?email=t1@g

    @GetMapping("/getGroupByTeacherEmail")
    public ResponseEntity getGroupByTeacherEmail(@RequestParam("email") String email)  {
        List<StudentGroup> groups = studentGroupRepository.findGroupByTeacherEmail(email);
        ModelMapper modelMapper = new ModelMapper();
        List<StudentGroupSmallDto> groupsDto = groups.stream()
                .map(group -> modelMapper.map(group, StudentGroupSmallDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(groupsDto);
    }    //http://localhost:8080/api/teacher/getGroupByTeacherEmail?email=t914@g

    @GetMapping("/getStudentByStudentGroupName")
    public ResponseEntity getStudentByStudentGroupName(@RequestParam("name") String name)  {
        List<Student> students = studentDegreeRepository.findStudentByStudentGroupName(name);
        ModelMapper modelMapper = new ModelMapper();
        List<StudentDto> studentDto = students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(studentDto);
        }    //http://localhost:8080/api/teacher/getStudentByStudentGroupName?name=ТТ-74

    @GetMapping("/getGroupInfo")
    public ResponseEntity getGroupInfo(@RequestParam("id") Integer id) {
        StudentGroup group = studentGroupRepository.findAllById(id);
        ModelMapper modelMapper = new ModelMapper();
        return ResponseEntity.ok(modelMapper.map(group, StudentGroupDto.class));
    }    //http://localhost:8080/api/teacher/getGroupInfo?id=2171

}
