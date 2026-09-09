package org.example.entity;

/*
 * Student represents the data/model of our application.
 *
 * It contains the information related to a student:
 * - id
 * - name
 * - email
 *
 * This object is also used to receive request data and
 * send response data in our Spring MVC application.
 */

public class Student {

    private Long id;
    private String name;
    private String email;


    // Getters and Setters
    // These methods are used to access and modify the private fields.

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
}