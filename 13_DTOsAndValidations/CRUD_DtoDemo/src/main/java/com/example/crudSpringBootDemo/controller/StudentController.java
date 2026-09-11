package com.example.crudSpringBootDemo.controller;

import com.example.crudSpringBootDemo.dto.CreateStudentRequestDTO;
import com.example.crudSpringBootDemo.dto.StudentResponseDTO;
import com.example.crudSpringBootDemo.dto.UpdateStudentRequestDTO;
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
    public ResponseEntity<StudentResponseDTO> createStudent(
            @Valid @RequestBody CreateStudentRequestDTO requestDTO) {

        StudentResponseDTO response =
                studentService.createStudent(requestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


    // =========================================================
    // GET ONE
    // =========================================================

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudent(
            @PathVariable Long id) {

        StudentResponseDTO response =
                studentService.getStudent(id);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }


    // =========================================================
    // GET ALL
    // =========================================================

    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {

        List<StudentResponseDTO> students =
                studentService.getAllStudents();

        /*
            An empty list is still a successful GET response.

            Therefore:

            [] -> 200 OK

            instead of:

            404 NOT FOUND
        */

        return ResponseEntity.ok(students);
    }


    // =========================================================
    // UPDATE
    // =========================================================

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStudentRequestDTO requestDTO) {

        StudentResponseDTO response =
                studentService.updateStudent(id, requestDTO);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }


    // =========================================================
    // HARD DELETE
    // =========================================================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable Long id) {

        boolean deleted =
                studentService.deleteStudent(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                "Student permanently deleted"
        );
    }


    // =========================================================
    // SOFT DELETE
    // =========================================================

    @PatchMapping("/{id}")
    public ResponseEntity<String> softDeleteStudent(
            @PathVariable Long id) {

        boolean deleted =
                studentService.softDeleteStudent(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                "Student soft deleted successfully"
        );
    }
}