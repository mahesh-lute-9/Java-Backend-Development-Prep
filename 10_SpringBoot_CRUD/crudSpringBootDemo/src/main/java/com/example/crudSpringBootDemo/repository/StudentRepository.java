package com.example.crudSpringBootDemo.repository;

import com.example.crudSpringBootDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {  //JpaRepository? CrudRepository?

    // here how does it possible it does not give error even if we don't override none of it's methods
}


// SQL query --> Methods(Spring JPA) -- Jakarta Persistent API
/*
    - create --> save() --> Insert into student();
    - readAll --> findAll() --> select * from student();
    - readOne --> find() --> select * from student where .. ;
    - update --> save(), existsById()
    - delete --> deleteById()

    we use all these predefined methods so that we should not have to write sql queries for it
 */