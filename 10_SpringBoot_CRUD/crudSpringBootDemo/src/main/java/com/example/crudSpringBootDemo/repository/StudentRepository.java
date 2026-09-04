package com.example.crudSpringBootDemo.repository;

import com.example.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository     // Marks this interface as a repository component used for database operations.
//@Component    // Generic Spring bean annotation; @Repository is more specific and preferred here.

// Why did we make it an interface?
// Spring Data JPA creates the implementation of this interface automatically at runtime.
// We only define the repository contract; we don't need to write the implementation ourselves.
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Why don't we override JpaRepository methods?
    // JpaRepository already provides predefined CRUD methods.
    // Spring Data JPA provides their implementation automatically through a proxy object.
}


// JpaRepository<Student, Long>
// Student -> Entity type this repository works with.
// Long    -> Data type of the entity's primary key (Student.id).


// JpaRepository vs CrudRepository:
// CrudRepository provides basic CRUD operations.
// JpaRepository extends CrudRepository and provides additional JPA-specific
// features such as pagination, sorting, and batch-related operations.


// SQL query --> Spring Data JPA method --> JPA/Hibernate --> Database
/*
    Create   --> save()
    Read All --> findAll()
    Read One --> findById()
    Update   --> save()
    Delete   --> deleteById()

    We use predefined methods so we don't have to write common SQL queries manually.
 */