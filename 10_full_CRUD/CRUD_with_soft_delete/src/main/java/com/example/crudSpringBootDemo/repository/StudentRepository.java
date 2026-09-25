package com.example.crudSpringBootDemo.repository;

import com.example.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository     // Marks this interface as a repository component used for database operations.
//@Component    // Generic Spring bean annotation; @Repository is more specific and preferred here.

// Why did we make it an interface?
// Spring Data JPA creates the implementation of this interface automatically at runtime.
// We only define the repository contract; we don't need to write the implementation ourselves.
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Why don't we override JpaRepository methods?
    // JpaRepository already provides predefined CRUD methods.
    // Spring Data JPA provides their implementation automatically through a proxy object.


    // Soft Delete:
    // Instead of permanently deleting a student record from the database,
    // we mark the record as deleted by changing the "deleted" field to true.
    //
    // Since JpaRepository's findById() does not know about our Soft Delete logic,
    // we create a custom derived query method that also checks deleted = false.

    // Finds a student only when:
    // 1. The given ID matches.
    // 2. The deleted field is false.
    //
    // Spring Data JPA reads the method name and automatically creates
    // the required query at runtime.
    //
    // Equivalent SQL concept:
    // SELECT * FROM student WHERE id = ? AND deleted = false;
    Optional<Student> findByIdAndDeletedFalse(Long id);


    // Finds all students where deleted = false.
    //
    // This is used instead of findAll() when we want to fetch only
    // active/non-deleted students.
    //
    // "DeletedIsFalse" is understood automatically by Spring Data JPA
    // and the implementation is generated at runtime.
    //
    // Equivalent SQL concept:
    // SELECT * FROM student WHERE deleted = false;
    List<Student> findByDeletedIsFalse();
}


// JpaRepository<Student, Long>
// Student -> Entity type this repository works with.
// Long    -> Data type of the entity's primary key (Student.id).


// JpaRepository vs CrudRepository:
// CrudRepository provides basic CRUD operations.
// JpaRepository extends CrudRepository and provides additional JPA-specific
// features such as pagination, sorting, and batch-related operations.


// Derived Query Methods:
// Spring Data JPA can create queries automatically by reading
// the method name that we define in the repository.
//
// Examples:
// findByIdAndDeletedFalse()
// -> Finds a student by ID where deleted = false.
//
// findByDeletedIsFalse()
// -> Finds all students where deleted = false.
//
// We don't have to manually write SQL for these queries.
// Spring Data JPA parses the method name and creates the query automatically.


// SQL query --> Spring Data JPA method --> JPA/Hibernate --> Database
/*
    Create   --> save()
    Read All --> findAll()
    Read One --> findById()
    Update   --> save()
    Delete   --> deleteById()

    With Soft Delete, the Delete operation is handled differently.

    Hard Delete:
    DELETE API --> deleteById() --> Record permanently removed from database

    Soft Delete:
    DELETE API --> update deleted = true --> Record remains in database

    Therefore, for normal Read operations we use:

    Read All --> findByDeletedIsFalse()
    Read One --> findByIdAndDeletedFalse()

    This allows us to keep the record in the database while
    preventing soft-deleted records from appearing in normal results.
 */