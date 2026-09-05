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
*/