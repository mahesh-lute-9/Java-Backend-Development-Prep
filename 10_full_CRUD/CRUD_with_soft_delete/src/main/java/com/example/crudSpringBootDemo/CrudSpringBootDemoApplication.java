package com.example.crudSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

// @SpringBootApplication is the main annotation of a Spring Boot application.
// It is a combination of:
// 1. @SpringBootConfiguration -> marks this class as a configuration class.
// 2. @EnableAutoConfiguration -> automatically configures required components
//    based on dependencies and application properties.
// 3. @ComponentScan -> scans this package and its sub-packages for Spring beans.
//
// Since this class is in the root package, Spring can automatically find:
// Controller, Service, Repository, etc.

@SpringBootApplication
public class CrudSpringBootDemoApplication {

	public static void main(String[] args) {

		// Starts the Spring Boot application.
		//
		// SpringApplication.run() creates the Spring ApplicationContext
		// (IoC Container), performs component scanning, applies auto-configuration,
		// creates/manages beans, and starts the embedded server.
		//
		// In our application, Spring discovers and manages:
		// Controller -> Service -> Repository
		//
		// Spring also configures JPA/Hibernate and the DataSource
		// based on our dependencies and application.properties.
		//
		// The Soft Delete functionality that we added also becomes
		// part of this application flow:
		//
		// Controller
		//     ↓
		// Service
		//     ↓
		// Repository
		//     ↓
		// PostgreSQL

		SpringApplication.run(CrudSpringBootDemoApplication.class, args);
	}
}


/*
    ============================
    IMPORTANT INTERVIEW CONCEPTS
    ============================


    1. What is @SpringBootApplication?

    @SpringBootApplication is a combination of:

        @SpringBootConfiguration
        @EnableAutoConfiguration
        @ComponentScan


    2. What is @EnableAutoConfiguration?

    It tells Spring Boot to automatically configure the application
    based on the dependencies available in the project and the
    configuration provided in application.properties.

    Example in our project:

        Spring Data JPA
        + PostgreSQL JDBC Driver
        + datasource properties
                    ↓
        Spring Boot Auto-Configuration
                    ↓
        DataSource + JPA/Hibernate configuration


    3. What is @ComponentScan?

    It tells Spring to scan for Spring-managed components such as:

        @Controller
        @RestController
        @Service
        @Repository
        @Component

    It scans the package containing the main class and its sub-packages.

    That's why our structure works:

        com.example.crudSpringBootDemo
        │
        ├── CrudSpringBootDemoApplication
        ├── controller
        ├── service
        ├── repository
        └── entity


    4. What is SpringApplication.run()?

    It starts the Spring Boot application.

    High-level flow:

        main()
          ↓
        SpringApplication.run()
          ↓
        Create ApplicationContext
          ↓
        Component Scanning
          ↓
        Auto-Configuration
          ↓
        Create & Manage Beans
          ↓
        Configure DataSource / JPA
          ↓
        Start Embedded Server
          ↓
        Application Ready


    5. What is ApplicationContext?

    ApplicationContext is the Spring IoC container.

    It is responsible for:
        - Creating beans
        - Managing beans
        - Injecting dependencies
        - Managing bean lifecycle

    Example:

        StudentController
              ↓
        StudentService
              ↓
        StudentRepository

    We don't manually create these objects using 'new'.
    Spring creates and manages them.


    6. What is a Spring Bean?

    A Bean is an object that is created and managed by Spring's
    IoC container.

    Examples from our project:

        @RestController → StudentController bean
        @Service        → StudentService bean
        @Repository     → StudentRepository bean


    7. What is IoC?

    IoC = Inversion of Control.

    Normally, our code creates and manages objects:

        StudentService service = new StudentService(...);

    With Spring, the control is given to Spring.

        Spring → creates and manages objects

    This is called Inversion of Control.


    8. What is Dependency Injection?

    Dependency Injection is the process by which Spring provides
    required dependencies to a class.

    Example:

        public StudentService(StudentRepository studentRepository)

    StudentService needs StudentRepository.

    Instead of creating it manually, Spring provides it through
    the constructor.

    This project uses Constructor Dependency Injection.


    9. Why is Constructor Injection preferred?

    It makes dependencies explicit.

    Example:

        StudentService(StudentRepository studentRepository)

    This clearly tells us that StudentService requires
    StudentRepository to work.

    It also makes the class easier to test and avoids manually
    creating dependencies.


    10. Why should the main class be in the root package?

    Because @ComponentScan scans the package containing the main
    class and its sub-packages.

    Therefore:

        com.example.crudSpringBootDemo
                    ↓
        controller
        service
        repository

    are automatically scanned.

    If the main class is placed in an unrelated package,
    Spring may not automatically discover these components.


    11. What is Auto-Configuration?

    Auto-configuration means Spring Boot automatically configures
    common application components based on the project's
    dependencies and configuration.

    In our project:

        JPA + PostgreSQL Driver + Datasource properties
                          ↓
                  Auto-Configuration
                          ↓
                DataSource / JPA setup


    12. What is DataSource?

    DataSource provides database connections to the application.

        Spring Boot
             ↓
          DataSource
             ↓
       PostgreSQL JDBC Driver
             ↓
         PostgreSQL


    13. What is the PostgreSQL JDBC Driver?

    It is the library that allows Java applications to communicate
    with PostgreSQL using JDBC.

        Java
         ↓
        JDBC
         ↓
    PostgreSQL Driver
         ↓
    PostgreSQL Database


    14. What was the initial DataSource error?

    Error:

        Failed to configure a DataSource:
        'url' attribute is not specified and no embedded datasource
        could be configured.

        Reason:
        Failed to determine a suitable driver class


    This happened because Spring Boot detected that database
    configuration was required but could not find a suitable
    datasource configuration/driver.

    We solved it by providing PostgreSQL datasource configuration
    in application.properties and using the PostgreSQL JDBC driver.


    15. Why did we initially exclude DataSourceAutoConfiguration?

        @SpringBootApplication(
            exclude = {DataSourceAutoConfiguration.class}
        )

    This tells Spring Boot not to automatically configure the
    DataSource.

    This can be useful when the application does not need a database
    or database configuration is being handled manually.

    But our CRUD application needs PostgreSQL, so we use:

        @SpringBootApplication

    and allow Spring Boot to configure the DataSource automatically.


    16. Spring vs Spring Boot?

    Spring Framework:
        Provides features such as:
        - IoC
        - Dependency Injection
        - AOP
        - MVC
        - Transaction Management

    Spring Boot:
        Simplifies Spring application development using:
        - Auto-Configuration
        - Starter dependencies
        - Embedded servers
        - Convention over configuration


    17. Why don't we create StudentController manually?

    Because Spring manages it as a Bean.

        @RestController
        public class StudentController

    Spring detects it during component scanning,
    creates its object, and injects its dependencies.


    18. COMPLETE APPLICATION STARTUP FLOW

        main()
          ↓
        SpringApplication.run()
          ↓
        ApplicationContext
          ↓
        Component Scanning
          ↓
        Auto-Configuration
          ↓
        Beans Created
          ↓
        DataSource configured
          ↓
        JPA/Hibernate configured
          ↓
        Embedded Server starts


    19. COMPLETE REQUEST FLOW

    Example:

        POST /api/students

    Postman
       ↓
    Controller
       ↓
    @RequestBody + Jackson
       ↓
    Student Java Object
       ↓
    Service
       ↓
    Repository
       ↓
    Spring Data JPA
       ↓
    Hibernate
       ↓
    JDBC Driver
       ↓
    PostgreSQL


    This is the overall architecture and request flow of our
    Spring Boot CRUD application.



    ================================================================
                    SOFT DELETE INTERVIEW CONCEPTS
    ================================================================


    20. What is Soft Delete?

    Soft Delete is a technique where we do not physically remove
    a record from the database.

    Instead, we mark the record as deleted using a field such as:

        deleted = true

    The record still exists in the database but is excluded from
    normal application queries.


    21. What is the difference between Soft Delete and Hard Delete?

    Hard Delete:
        The record is physically removed from the database.

        Example:
        repository.deleteById(id);


    Soft Delete:
        The record is not physically removed.
        Instead, we update a field:

        deleted = true

    Example:

        Before:
        deleted = false

        After:
        deleted = true


    22. Why is Soft Delete used in real-world applications?

    Soft Delete can be useful when we need to:

        - Preserve historical data
        - Recover accidentally deleted records
        - Maintain audit/history information
        - Keep records for reporting
        - Avoid permanently losing data

    Instead of destroying the record, we simply mark it as deleted.


    23. How did we implement Soft Delete in our project?

    We added a new field to the Student entity:

        private Boolean deleted;

    Then we follow this flow:

        Create Student
             ↓
        deleted = false
             ↓
        Student is active

        Soft Delete
             ↓
        deleted = true
             ↓
        Student is considered deleted

    The record itself remains in PostgreSQL.


    24. Why do we set deleted = false while creating a student?

    A newly created student should be considered active.

        studentRequest.setDeleted(false);

    Therefore:

        false → Active
        true  → Soft Deleted

    This gives every newly created record a known initial state.


    25. Why did we use PATCH for Soft Delete?

    PATCH is generally used when we want to partially modify
    an existing resource.

    In Soft Delete, we are not removing the complete resource.

    We are only changing one field:

        deleted = false
                    ↓
        deleted = true

    Therefore, PATCH is a suitable HTTP method for this operation.


    26. Why don't we use deleteById() for Soft Delete?

    deleteById() performs an actual delete operation.

    It physically removes the entity from the database.

    Soft Delete requires the record to remain in the database.

    Therefore, instead of:

        deleteById(id)

    we do:

        find record
             ↓
        deleted = true
             ↓
        save()


    27. How does our Soft Delete method work?

    Our service follows these steps:

        1. Find the active student.
        2. Check whether the student exists.
        3. Set deleted = true.
        4. Save the updated entity.

    Code flow:

        findByIdAndDeletedFalse(id)
                    ↓
              Get Student
                    ↓
             deleted = true
                    ↓
                  save()


    28. What is a Derived Query Method?

    A Derived Query Method is a repository method where
    Spring Data JPA derives the query from the method name.

    Example:

        findByDeletedIsFalse()

    Spring Data JPA understands the method name and automatically
    creates the required query.

    We don't need to manually write the SQL query for this case.


    29. What does findByDeletedIsFalse() do?

    It retrieves only records where:

        deleted = false

    SQL concept:

        SELECT * FROM student
        WHERE deleted = false;

    Therefore, soft-deleted records are excluded from
    the normal "Get All Students" operation.


    30. What does findByIdAndDeletedFalse() do?

    It searches for a student using two conditions:

        1. ID matches.
        2. deleted = false.

    SQL concept:

        SELECT * FROM student
        WHERE id = ?
        AND deleted = false;

    This prevents an already soft-deleted student from being
    returned through the normal Get By ID operation.


    31. Why can't we simply use findById() after implementing Soft Delete?

    findById() only checks the primary key.

    It does not automatically know that:

        deleted = true

    records should be excluded.

    Therefore, findById() could return a soft-deleted record.

    We created:

        findByIdAndDeletedFalse(id)

    so that both conditions are checked.


    32. What happens to the record in PostgreSQL after Soft Delete?

    The record is NOT removed.

    Only the value of the deleted column changes.

    Example:

        Before:

        id       = 1
        name     = "Rahul"
        deleted  = false


        After Soft Delete:

        id       = 1
        name     = "Rahul"
        deleted  = true

    The same row still exists in PostgreSQL.


    33. Can a Soft Deleted record be restored?

    Yes.

    Since the record still exists in the database,
    we can potentially restore it by changing:

        deleted = true

    back to:

        deleted = false

    This is one of the advantages of Soft Delete over Hard Delete.

    However, the application needs a separate restore operation
    if restoration is required.


    34. What happens if we try to update a Soft Deleted student?

    In our implementation, the update operation first uses:

        findByIdAndDeletedFalse(id)

    Therefore, a soft-deleted student is not returned.

    As a result, the normal Update API will return:

        404 NOT FOUND

    This prevents normal CRUD operations from modifying
    soft-deleted records.


    35. Why do we still use existsById() for Hard Delete?

    Our Hard Delete method is intentionally different.

        existsById(id)
              ↓
        deleteById(id)

    We want the Hard Delete operation to permanently remove
    an existing database record, including a record that may
    already have deleted = true.

    Therefore, we don't apply the "deleted = false" condition
    to this operation.


    36. What is the complete Soft Delete request flow?

    Example:

        PATCH /api/students?id=1

    Postman
       ↓
    StudentController
       ↓
    softDeleteStudent()
       ↓
    StudentService
       ↓
    deleteStudentSoftly()
       ↓
    StudentRepository
       ↓
    findByIdAndDeletedFalse()
       ↓
    Student Entity
       ↓
    deleted = true
       ↓
    repository.save()
       ↓
    Hibernate / JPA
       ↓
    PostgreSQL


    The row remains in PostgreSQL.


    37. What is the difference between the Hard Delete and
        Soft Delete APIs in our project?

    Hard Delete:

        DELETE /api/students?id=1
                    ↓
             deleteById(id)
                    ↓
          Record physically removed


    Soft Delete:

        PATCH /api/students?id=1
                    ↓
        deleted = true
                    ↓
              save(entity)
                    ↓
          Record remains in database


    38. What happens during normal Read operations after
        implementing Soft Delete?

    We no longer want soft-deleted records to appear in
    normal application responses.

    Therefore:

        Get All:
        findByDeletedIsFalse()

        Get One:
        findByIdAndDeletedFalse(id)

    This ensures:

        deleted = false → Included
        deleted = true  → Excluded


    39. Where should Soft Delete logic be handled?

    In our project, the Soft Delete business logic is handled
    in the Service layer.

        Controller
            ↓
        Service
            ↓
        Repository

    Controller:
        Receives the API request.

    Service:
        Contains the Soft Delete business logic.

    Repository:
        Communicates with the database.


    40. Why do we use save() for Soft Delete?

    Because Soft Delete is an UPDATE operation, not a DELETE operation.

    We change:

        deleted = false

    to:

        deleted = true

    Then:

        repository.save(studentToSave);

    updates the existing record because the entity already
    contains its ID.


    41. COMPLETE SOFT DELETE ARCHITECTURE

        Client / Postman
                ↓
        PATCH /api/students?id=1
                ↓
        StudentController
                ↓
        StudentService
                ↓
        StudentRepository
                ↓
        Spring Data JPA
                ↓
        Hibernate
                ↓
        PostgreSQL


    Entity:
        Student
          ↓
        deleted field

    Repository:
        findByIdAndDeletedFalse()
        findByDeletedIsFalse()

    Service:
        deleteStudentSoftly()

    Controller:
        @PatchMapping


    This is how Soft Delete is implemented in our
    Spring Boot CRUD application.
*/