package org.example.controller;

import org.example.entity.Student;
import org.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// Marks this class as a Spring MVC REST controller.
//
// @RestController = @Controller + @ResponseBody
//
// This means:
// 1. Spring detects this class as a controller.
// 2. Return values from its methods are written directly
//    to the HTTP response body, usually as JSON.

@RequestMapping("/students")
// Defines the common base URL for all endpoints in this controller.
//
// Example:
// /students
// /students/{id}

public class StudentController {

    private final StudentService studentService;

    // Constructor Injection:
    // Spring automatically provides the StudentService object here.
    //
    // This is preferred over creating the service manually because
    // Spring manages the dependency and its lifecycle.

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    // Handles HTTP POST requests sent to:
    // /students
    //
    // POST is generally used to create a new resource.

    public ResponseEntity<Student> createStudent(

            @RequestBody Student studentReq) {
        // @RequestBody converts the JSON request body into a
        // Student Java object using an HTTP message converter
        // such as Jackson.

        Student studentResp = studentService.createStudent(studentReq);

        // Business logic is delegated to the Service layer
        // instead of keeping it inside the Controller.

        return ResponseEntity.ok(studentResp);
        // Returns:
        // HTTP 200 OK + Student object in the response body.
    }


    @GetMapping("/{id}")
    // Handles HTTP GET requests such as:
    // /students/1
    //
    // GET is generally used to retrieve data.

    public ResponseEntity<Student> getStudent(

            @PathVariable("id") Long id) {
        // @PathVariable gets the value from the URL.
        //
        // Example:
        // /students/10
        // id = 10

        Student studentResp = studentService.getStudent(id);

        if (studentResp == null) {

            return ResponseEntity.notFound().build();
            // Returns HTTP 404 Not Found when the student
            // does not exist.
        }

        return ResponseEntity.ok(studentResp);
        // Returns HTTP 200 OK + Student object.
    }


    @GetMapping
    // Handles HTTP GET requests to:
    // /students
    //
    // Used here to retrieve all students.

    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> studentResp = studentService.getAllStudents();

        if (studentResp.isEmpty()) {

            return ResponseEntity.notFound().build();
            // Returns HTTP 404 when no students are available.
        }

        return ResponseEntity.ok(studentResp);
        // Returns HTTP 200 OK + list of students.
    }
}


/*
 * ============================================================
 * SPRING MVC ARCHITECTURE
 * ============================================================
 *
 * M --> Model
 *      Represents application data.
 *      Example: Student
 *
 * V --> View
 *      Represents the UI shown to the user.
 *      Example: HTML / JSP
 *
 * C --> Controller
 *      Handles incoming HTTP requests and coordinates
 *      with the Service layer.
 *
 * In this project, StudentController acts as the Controller.
 */
