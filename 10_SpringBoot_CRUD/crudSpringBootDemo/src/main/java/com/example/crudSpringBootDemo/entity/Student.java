package com.example.crudSpringBootDemo.entity;

import jakarta.persistence.*;

@Entity     // Marks this class as a JPA entity; Hibernate maps it to a database table.
public class Student {

    @Id     // Marks this field as the primary key of the Student table.
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@Column(nullable = false)
    private Long id;

    private String name;
    private String email;
    private int age;
    private int rollNo;
    private String subject;

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
}

// ORM (Object-Relational Mapping) maps Java objects/classes to relational database tables.