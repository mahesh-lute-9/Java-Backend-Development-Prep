package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student studentResp = studentService.createStudent(studentReq);

        return  ResponseEntity.ok(studentResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null){
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(@PathVariable Long id){
        List<Student> studentResp = studentService.getAllStudents();

        if(studentResp.isEmpty()){
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }
}
