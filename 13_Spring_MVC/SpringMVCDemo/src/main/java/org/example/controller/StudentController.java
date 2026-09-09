package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    //@ResponseBody
    public ResponseEntity<Student> createStudent(
            @RequestBody Student studentReq) {

        Student studentResp = studentService.createStudent(studentReq);

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/{id}")
    //@ResponseBody
    public ResponseEntity<Student> getStudent(
            @PathVariable("id") Long id) {

        Student studentResp = studentService.getStudent(id);

        if (studentResp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }

    @GetMapping
    //@ResponseBody
    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> studentResp = studentService.getAllStudents();

        if (studentResp.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResp);
    }
}


// M --> Model
// V --> View(html/JSP)
// C --> Controller