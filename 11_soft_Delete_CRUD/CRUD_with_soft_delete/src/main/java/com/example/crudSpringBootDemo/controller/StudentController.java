package com.example.crudSpringBootDemo.controller;

//import org.springframework.stereotype.Component;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Component
// Generic annotation used to register a class as a Spring Bean.
// @RestController is more specific for REST API controllers.

@RestController
// Marks this class as a REST controller.
// It combines @Controller + @ResponseBody.
// @ResponseBody means the returned object is written directly to the HTTP response,
// usually as JSON using Jackson.

@RequestMapping("/api/students")
// Defines the common/base URL for all endpoints in this controller.
// Example: @GetMapping("/{id}") becomes /api/students/{id}.
public class StudentController {

    private StudentService studentService;

    // Constructor Injection: Spring automatically provides the StudentService bean.
    // This is preferred over manually creating the object using new.
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Create student
    @PostMapping
    // Maps HTTP POST /api/students to this method.
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        // @RequestBody tells Spring to take the JSON request body
        // and convert it into a Student object.
        // Jackson performs the JSON <-> Java object conversion.

        Student createdStudent = studentService.createStudent(student);

        // 201 CREATED indicates that a new resource was successfully created.
        // ResponseEntity allows us to control both the response body and HTTP status code.
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }


    // Read one student by ID
    @GetMapping("/{id}")
    // Example: GET /api/students/1
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        // @PathVariable extracts the {id} value from the URL
        // and passes it to the method as a Java variable.

        Student studentResponse = studentService.getStudent(id);

        if(studentResponse == null){
            return ResponseEntity.notFound().build();    // 404 NOT FOUND
        }

        return ResponseEntity.ok(studentResponse);      // 200 OK
    }


    // Read all students
    @GetMapping
    // Maps GET /api/students
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> studentsList = studentService.getAllStudent();

        if(studentsList.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentsList);
    }


    // Update student
    @PutMapping("/{id}")
    // Example: PUT /api/students/1
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student studentRequest){

        // id comes from the URL.
        // studentRequest comes from the JSON request body.

        Student studentResponse = studentService.updateStudent(id, studentRequest);

        if(studentResponse == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResponse);
    }


    // Delete student
    @DeleteMapping("/{id}")
    // Example: DELETE /api/students/1
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){

        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record Deleted");
    }


    // soft-delete student
    @PatchMapping("/{id}")
    // Example: PATCH /api/students/{id}
    public ResponseEntity<String> softDeleteStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok("Record deleted(Softly)");
    }
}