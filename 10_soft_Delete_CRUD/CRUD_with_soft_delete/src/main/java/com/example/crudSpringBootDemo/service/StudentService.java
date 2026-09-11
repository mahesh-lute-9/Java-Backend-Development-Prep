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

        // For every newly created student, deleted should be false.
        // false means that the student is active and has not been deleted.
        studentRequest.setDeleted(false);

        // Repository handles the actual database operation.
        Student studentResponse = studentRepository.save(studentRequest);

        return studentResponse;
    }


    public Student getStudent(Long id){

        // findByIdAndDeletedFalse() returns Optional because the requested
        // student may not exist OR the student may already be soft-deleted.
        //
        // We don't use findById() here because it could also return
        // a record where deleted = true.
        Optional<Student> studentResponse =
                studentRepository.findByIdAndDeletedFalse(id);

        if(studentResponse.isPresent()){
            return studentResponse.get();
        }

        return null;
    }

    /*
        Previously:
        findById(id)
        -> Could return both active and soft-deleted records.

        Now:
        findByIdAndDeletedFalse(id)
        -> Returns only records where deleted = false.

        Example SQL concept:
        SELECT * FROM student
        WHERE id = ? AND deleted = false;

        Since soft-deleted records should normally not participate
        in regular CRUD operations, we use custom repository methods
        wherever we need to read active records.

        Syntax for creating a Derived Query Method:
        findBy + FieldName + Condition

        Example:
        findByDeletedIsFalse()
        findByIdAndDeletedFalse()
    */


    public List<Student> getAllStudent(){

        // Fetches only active students.
        // Soft-deleted students (deleted = true) are excluded.
        return studentRepository.findByDeletedIsFalse();

    }   // SQL concept:
    // SELECT * FROM student WHERE deleted = false;


    public Student updateStudent(Long id, Student studentRequest){

        // First check whether the student exists and is NOT soft-deleted.
        //
        // A soft-deleted student should not be updated through
        // the normal Update API.
        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedFalse(id);

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

        // Keep the record marked as active after updating.
        studentToSave.setDeleted(false);

        // save() updates the existing record because the entity already has its ID.
        return studentRepository.save(studentToSave);
    }


    public boolean deleteStudent(Long id){

        // Check whether the record exists before attempting to delete it.
        //
        // Here we intentionally use existsById() because this method
        // represents Hard Delete and we want to physically delete
        // the record regardless of its "deleted" flag.
        Boolean isStudent = studentRepository.existsById(id);

        // No changes are required here because Hard Delete should
        // remove the record from the database permanently.
        // This can remove both active and already soft-deleted records.
        if(!isStudent) return false;

        studentRepository.deleteById(id);

        return true;
    }


    public boolean deleteStudentSoftly(Long id){

        /*
            Soft Delete flow:

            1. Get the existing active record.
            2. Change deleted from false -> true.
            3. Save the updated entity.

            The record is NOT physically removed from the database.
        */

        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedFalse(id);

        // If the student doesn't exist OR is already soft-deleted,
        // there is nothing to soft-delete.
        if(existingStudent.isEmpty()){
            return false;
        }

        // Get the existing entity.
        Student studentToSave = existingStudent.get();

        // Mark the student as deleted instead of removing the row.
        studentToSave.setDeleted(true);

        // save() updates the existing database record.
        // The record remains in PostgreSQL, but deleted becomes true.
        studentRepository.save(studentToSave);

        return true;
    }
}