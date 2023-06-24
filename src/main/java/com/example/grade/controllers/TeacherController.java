package com.example.grade.controllers;

import com.example.grade.dto.*;
import com.example.grade.models.*;
import com.example.grade.repositories.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherRepository teacherRepository;
    private final GradeRepository gradeRepository;
    private final CourseRepository courseRepository;
    private final CourseNameRepository courseNameRepository;
    private final AbsenceRepository absenceRepository;


    private final StudentDegreeRepository studentDegreeRepository;
    private final StudentGroupRepository studentGroupRepository;

    @Operation(summary = "Приймає email викладача і повертає інформацію про нього.")
    @GetMapping("/getTeacherInfoByEmail")
    public ResponseEntity getTeacherInfoByEmail(@RequestParam("email") String email) {
        Teacher teacher = teacherRepository.findByEmail(email).get();
        ModelMapper modelMapper = new ModelMapper();
        return ResponseEntity.ok(modelMapper.map(teacher, TeacherDto.class));
    }    //http://localhost:8080/api/teacher/getTeacherInfoByEmail?email=t1@g

    @Operation(summary = "Приймає email викладача і повертає список його груп.")
    @GetMapping("/getGroupByTeacherEmail")
    public ResponseEntity getGroupByTeacherEmail(@RequestParam("email") String email) {
        List<StudentGroup> groups = studentGroupRepository.findGroupByTeacherEmail(email);
        ModelMapper modelMapper = new ModelMapper();
        List<StudentGroupSmallDto> groupsDto = groups.stream()
                .map(group -> modelMapper.map(group, StudentGroupSmallDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(groupsDto);
    }    //http://localhost:8080/api/teacher/getGroupByTeacherEmail?email=t914@g

    @Operation(summary = "Приймає id групи і повертає список студентів групи.")
    @GetMapping("/getStudentsByStudentGroupId")
    public ResponseEntity getStudentsByStudentGroupId(@RequestParam("id") Integer id) {
        List<Student> students = studentDegreeRepository.findStudentByStudentGroupId(id);
        ModelMapper modelMapper = new ModelMapper();
        List<StudentDto> studentDto = students.stream()
                .map(student -> modelMapper.map(student, StudentDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(studentDto);
    }    //http://localhost:8080/api/teacher/getStudentsByStudentGroupId?id=1067

    @Operation(summary = "Приймає id групи і повертає інформацію про неї.")
    @GetMapping("/getGroupInfo")
    public ResponseEntity getGroupInfo(@RequestParam("id") Integer id) {
        StudentGroup group = studentGroupRepository.findAllById(id);
        ModelMapper modelMapper = new ModelMapper();
        return ResponseEntity.ok(modelMapper.map(group, StudentGroupDto.class));
    }    //http://localhost:8080/api/teacher/getGroupInfo?id=2171

    @Operation(summary = "Приймає email і повертає чи належить він викладачу чи студенту.")
    @GetMapping("/getTeacherOrStudentByEmail")
    public String getTeacherOrStudentByEmail(@RequestParam("email") String email) {
        return teacherRepository.findTeacherOrStudentByEmail(email);
    }    //http://localhost:8080/api/teacher/getTeacherOrStudentByEmail?email=t914@g

    @Operation(summary = "Приймає email викладача і семестр -- повертає список предметів викладача.")
    @GetMapping("/getCourseByTeacherEmail")
    public ResponseEntity getCourseByTeacherEmail(@RequestParam("email") String email,
                                                  @RequestParam("semester") Integer semester) {
        List<CoursesForGroup> groups = studentGroupRepository.findCourseByTeacherEmail(email, semester);
        ModelMapper modelMapper = new ModelMapper();
        List<CoursesForGroupDto> groupsDto = groups.stream()
                .map(group -> modelMapper.map(group, CoursesForGroupDto.class))
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok(groupsDto);
    }    //http://localhost:8080/api/teacher/getCourseByTeacherEmail?email=t914@g&semester=3

    @Operation(summary = "Приймає email викладача, семестр, id предмета і повертає список груп.")
    @GetMapping("/getGroupByEmailSemesterAndIdNameCourse")
    public ResponseEntity getGroupByEmailSemesterAndIdNameCourse(@RequestParam("email") String email,
                                                                 @RequestParam("semester") Integer semester,
                                                                 @RequestParam("id") Integer id) {
        List<CoursesForGroup> groups = studentGroupRepository.findGroupByEmailSemesterAndIdNameCourse(email, semester, id);
        ModelMapper modelMapper = new ModelMapper();
        List<StudentGroupSmallDto> groupsDto = groups.stream()
                .map(group -> modelMapper.map(group, StudentGroupSmallDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(groupsDto);
    }    //http://localhost:8080/api/teacher/getGroupByEmailSemesterAndIdNameCourse?email=t914@g&semester=3&id=2075


    @Operation(summary = "Додавання оцінок, приймає індентифікатор студента, курса, та семестра")
    @PostMapping("/setGradeForStudentId")
    public GradeDtoSetGrade setGradeForStudentId(@RequestParam("studentId") int studentId,
                                                 @RequestParam("courseId") int courseId,
                                                 @RequestParam("grade") int grade,
                                                 @RequestParam("semester") int semester,
                                                 @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                 LocalDate date) {
        // Получение объектов Student и Course из репозиториев
        StudentDegree studentDegree = studentDegreeRepository.findByStudentId(studentId).orElseThrow(() -> new EntityNotFoundException("StudentDegree not found"));

        CourseName courseName = courseNameRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("CourseName not found"));
        Course course = courseRepository.findByCourseNameAndSemester(courseName, semester).orElseThrow(() -> new EntityNotFoundException("Course not found"));

        // Создание объекта Grade
        Grade newGrade = new Grade();
        newGrade.setGrade(grade);
        newGrade.setCreatedAt(date.atStartOfDay().atOffset(ZoneOffset.UTC));
        newGrade.setStudentDegree(studentDegree);
        newGrade.setCourse(course);

        // Сохранение объекта Grade
        Grade savedGrade = gradeRepository.save(newGrade);

        return new GradeDtoSetGrade(savedGrade.getId(),
                savedGrade.getGrade(), savedGrade.getCreatedAt());
    }

    @Operation(summary = "Додавання оцінок, приймає індентифікатор студента, курса, та семестра")
    @PostMapping("/setAbsenceForStudentId")
    public AbsenceDtoSetAbsence setAbsenceForStudentId(@RequestParam("studentId") int studentId,
                                                       @RequestParam("courseId") int courseId,
                                                       @RequestParam("semester") int semester,
                                                       @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                       LocalDate date) {
        // Получение объектов Student и Course из репозиториев
        StudentDegree studentDegree = studentDegreeRepository.findByStudentId(studentId).orElseThrow(() -> new EntityNotFoundException("StudentDegree not found"));

        CourseName courseName = courseNameRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("CourseName not found"));
        Course course = courseRepository.findByCourseNameAndSemester(courseName, semester).orElseThrow(() -> new EntityNotFoundException("Course not found"));

        // Создание объекта Grade
        Absence newAbsence = new Absence();
        newAbsence.setData(date.atStartOfDay().atOffset(ZoneOffset.UTC));
        newAbsence.setStudentDegree(studentDegree);
        newAbsence.setCourse(course);

        // Сохранение объекта Grade
        Absence savedAbsence = absenceRepository.save(newAbsence);

        return new AbsenceDtoSetAbsence(savedAbsence.getId(),
                savedAbsence.getData());
    }

    @Operation(summary = "Приймає дату і повертає чи є відсутність по даті")
    @GetMapping("/getBoolAbsenceNow")
    public Boolean getBoolAbsenceNow(@RequestParam("studentId") int studentId,
                                     @RequestParam("courseId") int courseId,
                                     @RequestParam("semester") int semester,
                                     @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                     LocalDate date) {
        // Получение объектов Student и Course из репозиториев
        StudentDegree studentDegree = studentDegreeRepository.findByStudentId(studentId).orElseThrow(() -> new EntityNotFoundException("StudentDegree id not found"));

        CourseName courseName = courseNameRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("CourseName not found"));
        Course course = courseRepository.findByCourseNameAndSemester(courseName, semester).orElseThrow(() -> new EntityNotFoundException("Course not found"));

        Absence absence = absenceRepository.findByDate(
                studentDegree.getId(),
                course.getId(),
                date.atStartOfDay().atOffset(ZoneOffset.UTC)
        );
        return absence != null;
    }
}
