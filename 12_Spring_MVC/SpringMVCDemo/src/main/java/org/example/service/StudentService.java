package org.example.service;

import org.example.entity.Student;
import org.example.repositoy.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Service layer:
 *
 * The Service layer contains the application's business logic.
 *
 * It acts as a middle layer between the Controller and Repository.
 *
 * Controller
 *     ↓
 * Service
 *     ↓
 * Repository
 */

@Service
// Marks this class as a Spring Service component.
// Spring creates and manages its object automatically.

public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection:
    // Spring provides the StudentRepository object when creating
    // the StudentService object.
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent(Student studentReq) {

        // The Service delegates the data-saving operation
        // to the Repository.
        return studentRepository.save(studentReq);
    }


    public Student getStudent(Long id) {

        // Ask the Repository to find a student by ID.
        return studentRepository.findById(id);
    }


    public List<Student> getAllStudents() {

        // Ask the Repository to return all students.
        return studentRepository.findAll();
    }
}