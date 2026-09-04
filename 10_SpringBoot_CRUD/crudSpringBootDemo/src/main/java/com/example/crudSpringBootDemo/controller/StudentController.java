package com.example.crudSpringBootDemo.controller;

//import org.springframework.stereotype.Component;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Component  // it is generic annotation to tell Spring that manage this class as bean
@RestController     // What is it?
@RequestMapping("/api/students")        // maps to endpoint. Explain
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // create student
    @PostMapping    //("/create") we add like this to make the endpoint valid is we want to be specific
    public ResponseEntity<Student> createStudent(@RequestBody Student student){        // @RequestBody? What, WHY, HOW? jackson library

        Student createdStudent = studentService.createStudent(student);

        //return ResponseEntity.ok(createdStudent);
        //return ResponseEntity.status(201).body(createdStudent);
        return  ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
        //return newly created student entity

        //if we want to return status code only then we've to change the return type
    }

    // read student

    // update student

    // delete student

}



/*
    this is better as convention
    create --> POST --> /api/students
    read one record --> GET --> /api/students/{id}
    read all --> GET --> /api/students
    update --> PUT --> /api/students/{id}
    delete --> DELETE --> /api/students/{id}
 */

/*
    this is better to know what it does actually
    create --> POST --> /api/students/create
    read one record --> GET --> /api/students/get/{id}
    read all --> GET --> /api/students/getAll
    update --> PUT --> /api/students/update/{id}
    delete --> DELETE --> /api/students//delete/{id}
 */