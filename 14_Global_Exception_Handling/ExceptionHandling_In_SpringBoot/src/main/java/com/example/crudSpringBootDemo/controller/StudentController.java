package com.example.crudSpringBootDemo.controller;

import com.example.crudSpringBootDemo.dto.CreateStudentRequestDto;
import com.example.crudSpringBootDemo.dto.CreateStudentResponseDto;
import com.example.crudSpringBootDemo.dto.UpdateStudentRequestDto;
import com.example.crudSpringBootDemo.dto.UpdateStudentResponseDto;
import com.example.crudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    // =========================================================
    // CREATE
    // =========================================================

    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(
            @Valid @RequestBody CreateStudentRequestDto requestDto) {

        CreateStudentResponseDto response =
                studentService.createStudent(requestDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    // =========================================================
    // GET ONE
    // =========================================================

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(
            @PathVariable Long id) {

        CreateStudentResponseDto response =
                studentService.getStudent(id);

        return ResponseEntity.ok(response);
    }


    // =========================================================
    // GET ALL
    // =========================================================

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudents() {

        List<CreateStudentResponseDto> students =
                studentService.getAllStudent();

        return ResponseEntity.ok(students);
    }


    // =========================================================
    // UPDATE
    // =========================================================

    @PutMapping("/{id}")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStudentRequestDto requestDto) {

        UpdateStudentResponseDto response =
                studentService.updateStudent(id, requestDto);

        return ResponseEntity.ok(response);
    }


    // =========================================================
    // HARD DELETE
    // =========================================================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }


    // =========================================================
    // SOFT DELETE
    // =========================================================

    @PatchMapping("/{id}")
    public ResponseEntity<String> softDeleteStudent(
            @PathVariable Long id) {

        studentService.deleteStudentSoftly(id);

        return ResponseEntity.noContent().build();
    }
}