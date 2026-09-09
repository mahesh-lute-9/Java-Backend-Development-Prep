package org.example.repositoy;

import org.example.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Repository layer:
 *
 * The Repository is responsible for managing and accessing data.
 *
 * In this project, we are using a HashMap as an in-memory database
 * instead of connecting to an actual database.
 */

@Repository
// Marks this class as a Spring Repository component.
// Spring will create and manage its object automatically.

public class StudentRepository {

    private final Map<Long, Student> studentDb;

    public StudentRepository() {

        // HashMap is used to temporarily store Student objects.
        //
        // Key   -> Student ID
        // Value -> Student object
        //
        // Example:
        // 1 -> Student(id=1, name="Mahesh", email="...")
        studentDb = new HashMap<>();
    }


    public Student save(Student studentReq) {

        // Store the student using its ID as the key.
        studentDb.put(studentReq.getId(), studentReq);

        // Return the saved student object.
        return studentReq;
    }


    public Student findById(Long id) {

        // Search the HashMap using the student ID.
        // Returns the Student if found, otherwise returns null.
        return studentDb.get(id);
    }


    public List<Student> findAll() {

        // studentDb.values() gives all Student objects stored
        // in the HashMap.
        //
        // A new ArrayList is created so that we return the data
        // as a List.
        return new ArrayList<>(studentDb.values());
    }
}