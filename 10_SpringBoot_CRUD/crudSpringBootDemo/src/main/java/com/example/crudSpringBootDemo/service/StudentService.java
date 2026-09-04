package com.example.crudSpringBootDemo.service;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// till, now we're doing everything using the @Component & telling Spring that you should manage this class as bean
//@Component
@Service
public class StudentService {

    // we're doing it all in One class
    // 1. End point listen (/api/students with diff methods)
    // 2. Business logic
    // 3. Interact with DB to store
    // 4. Response back to client(postman)
    // from now on we'll be devide these responsibilities as Controller-Service-Repository layers, it is architecture. WHY & HOW
    // POJO class, what it does? entity class

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentRequest){
        // business logic
        // store to db
        Student studentResponse = studentRepository.save(studentRequest);

        return studentResponse;
    }
}
