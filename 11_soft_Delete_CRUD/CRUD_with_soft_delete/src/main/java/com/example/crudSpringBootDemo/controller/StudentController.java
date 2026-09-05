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
    @GetMapping
    // Example: GET /api/students?id=1
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
        // @RequestParam extracts a value from the query parameter of the URL.
        //
        // Example:
        // GET /api/students?id=1
        //
        // Here, "id" from the request is passed to the method as a Long variable.
        //
        // @PathVariable is different:
        // GET /api/students/1
        // In that case, we would use @GetMapping("/{id}")
        // and @PathVariable Long id.

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
    @PutMapping
    // Example: PUT /api/students?id=1
    public ResponseEntity<Student> updateStudent(
            @RequestParam Long id,
            @RequestBody Student studentRequest){

        // id comes from the request parameter.
        // Example: PUT /api/students?id=1
        //
        // studentRequest comes from the JSON request body.

        Student studentResponse = studentService.updateStudent(id, studentRequest);

        if(studentResponse == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentResponse);
    }


    // Hard Delete student
    @DeleteMapping
    // Example: DELETE /api/students?id=1
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){

        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record Deleted");
    }


    // Soft Delete student
    @PatchMapping
    // Example: PATCH /api/students?id=1
    //
    // PATCH is used here because we are partially modifying the existing
    // student record instead of completely removing it from the database.
    //
    // In Soft Delete, the actual record is NOT removed.
    // Instead, the "deleted" field of the student is changed to true.
    public ResponseEntity<String> softDeleteStudent(@RequestParam Long id){

        // Passes the student ID to the service layer.
        // The service layer contains the actual Soft Delete business logic.
        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        // If no matching active student is found, return 404 NOT FOUND.
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

        // The record still exists in the database,
        // but it is now marked as deleted.
        return ResponseEntity.ok("Record deleted(Softly)");
    }
}