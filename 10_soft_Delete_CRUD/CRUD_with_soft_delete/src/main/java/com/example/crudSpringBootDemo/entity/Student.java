package com.example.crudSpringBootDemo.entity;

import jakarta.persistence.*;

@Entity     // Marks this class as a JPA entity; Hibernate maps it to a database table.
public class Student {

    @Id     // Marks this field as the primary key of the Student table.
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // use SEQUENCE or IDENTITY
    /*
        We don't set the id manually. Instead, we use @GeneratedValue
        so that the database/JPA can generate unique IDs automatically.

        If we manually assign IDs, there is a possibility of accidentally
        using an existing ID, which can cause conflicts with the primary key.

        GenerationType.SEQUENCE:
        Uses a database sequence to generate unique ID values.

        GenerationType.IDENTITY:
        Uses the database's identity/auto-increment mechanism.

        The exact strategy depends on the database being used.
        Here, we are using PostgreSQL.
    */
    //@Column(nullable = false)
    private Long id;

    private String name;
    private String email;
    private int age;
    private int rollNo;
    private String subject;

    /*
        Soft Delete:
        Instead of physically removing a student record from the database,
        we maintain a flag to indicate whether the record has been deleted.

        deleted = false -> Student is active.
        deleted = true  -> Student is soft-deleted.

        The record still exists in the database even after it is soft-deleted.
        We can then use this field in our repository queries to exclude
        deleted records from normal operations.
    */
    private Boolean deleted;


    // Getters and setters are used by JPA/Hibernate to access and modify entity fields.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}

// ORM (Object-Relational Mapping) maps Java objects/classes to relational database tables.