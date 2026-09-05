package com.example.crudSpringBootDemo.entity;

import jakarta.persistence.*;

@Entity     // Marks this class as a JPA entity; Hibernate maps it to a database table.
public class Student {

    @Id     // Marks this field as the primary key of the Student table.
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    /*
    ⦁	We don’t set id manually instead we use auto incremental id, where we use @GeneratedType.
    If we don’t we and give  manually id’s there would be scenario when two id matched and latest one
    override th last one so
     */
    //@Column(nullable = false)
    private Long id;

    private String name;
    private String email;
    private int age;
    private int rollNo;
    private String subject;
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