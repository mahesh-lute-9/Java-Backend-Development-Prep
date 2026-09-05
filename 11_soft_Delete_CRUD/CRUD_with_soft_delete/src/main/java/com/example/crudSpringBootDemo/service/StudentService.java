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
        // set all firstly as deleted = false
        studentRequest.setDeleted(false);
        // Repository handles the actual database operation.
        Student studentResponse = studentRepository.save(studentRequest);

        return studentResponse;
    }

    public Student getStudent(Long id){

        // findById() returns Optional because the requested record may not exist.
        Optional<Student> studentResponse = studentRepository.findByIdAndDeletedFalse(id);

        if(studentResponse.isPresent()){
            return studentResponse.get();
        }

        return null;
    }   // select * from student where i = 1;
    // now we have to also check deleted = false
    // if it is already has true value then it does not include in any CRUD operation
    // so instead of findById(), findAll(), existsById() all these we'll use other methods,
    // that we just name it and declare it in our repository and all the other work will be done by JPA
    // syntax to create the method --> findBy + field name + condition
    public List<Student> getAllStudent(){

        return studentRepository.findByDeletedIsFalse();
    }   // select * from students where deleted = false;


    public Student updateStudent(Long id, Student studentRequest){

        // First check whether the student exists.
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedFalse(id);

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
        // adding by default false while updating values in it
        studentToSave.setDeleted(false);
        // save() updates the existing record because the entity already has its ID.
        return studentRepository.save(studentToSave);
    }

    public boolean deleteStudent(Long id){

        // Check whether the record exists before attempting to delete it.
        Boolean isStudent = studentRepository.existsById(id);
        // here nothing to change as we want to delete all the rows the existing ones and marked as deleted one so we keep it as it is
        if(!isStudent) return false;

        studentRepository.deleteById(id);
        return true;
    }

    public boolean deleteStudentSoftly(Long id){
        // get record --> update the deleted = true --> save

        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedFalse(id);

        if(existingStudent.isEmpty()){
            return false;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);

        return true;
    }
}