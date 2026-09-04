package com.example.crudSpringBootDemo.service;

import com.example.crudSpringBootDemo.entity.Student;
import com.example.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// Marks this class as a Spring-managed service bean.
// The service layer contains business logic and sits between Controller and Repository.
public class StudentService {

    private StudentRepository studentRepository;

    // Constructor Injection: Spring provides the StudentRepository bean automatically.
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentRequest){

        // Repository handles the actual database operation.
        Student studentResponse = studentRepository.save(studentRequest);

        return studentResponse;
    }

    public Student getStudent(Long id){

        // findById() returns Optional because the requested record may not exist.
        Optional<Student> studentResponse = studentRepository.findById(id);

        if(studentResponse.isPresent()){
            return studentResponse.get();
        }

        return null;
    }

    public List<Student> getAllStudent(){

        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student studentRequest){

        // First check whether the student exists.
        Optional<Student> existingStudent = studentRepository.findById(id);

        if(existingStudent.isEmpty()){
            return null;
        }

        // Get the existing entity and update its fields.
        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentRequest.getName());
        studentToSave.setRollNo(studentRequest.getRollNo());
        studentToSave.setEmail(studentRequest.getEmail());
        studentToSave.setAge(studentRequest.getAge());
        studentToSave.setSubject(studentRequest.getSubject());

        // save() updates the existing record because the entity already has its ID.
        return studentRepository.save(studentToSave);
    }

    public boolean deleteStudent(Long id){

        // Check whether the record exists before attempting to delete it.
        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) return false;

        studentRepository.deleteById(id);
        return true;
    }
}