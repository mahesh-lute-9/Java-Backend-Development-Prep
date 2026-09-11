package com.example.crudDTODemo.service;

import com.example.crudDTODemo.entity.Student;
import com.example.crudDTODemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        return studentRepository.save(studentReq);
    }
}
