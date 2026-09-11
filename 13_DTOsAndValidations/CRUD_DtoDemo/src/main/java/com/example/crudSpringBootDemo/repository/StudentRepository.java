package com.example.crudSpringBootDemo.repository;

import com.example.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /*
        Find one student by ID only when the student is active.

        id = requested ID
        deleted = false
    */
    Optional<Student> findByIdAndDeletedFalse(Long id);


    /*
        Find all active students.

        deleted = false
    */
    List<Student> findByDeletedFalse();
}