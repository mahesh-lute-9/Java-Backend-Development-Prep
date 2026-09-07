package org.example.model;

/**
 * User represents a single user in our application.
 *
 * This class is a POJO (Plain Old Java Object).
 *
 * It contains:
 * - User ID
 * - User name
 * - User email
 * - User mobile number
 *
 * This class does NOT handle:
 * - Database operations
 * - HTTP requests
 * - Servlet logic
 * - CRUD operations
 *
 * Those responsibilities will be handled by other layers.
 */
public class User {

    // Unique identifier of the user.
    private Integer id;

    // Name of the user.
    private String name;

    // Email address of the user.
    private String email;

    // Mobile number of the user.
    private String mobileNo;


    /**
     * Constructor used to create a User object with all fields.
     *
     * Example:
     * User user = new User(1, "Mahesh", "mahesh@gmail.com", "9876543210");
     */
    public User(Integer id, String name, String email, String mobileNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
    }


    // =========================
    // Getters and Setters
    // =========================

    /**
     * Returns the user's ID.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Updates the user's ID.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns the user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the user's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the user's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Updates the user's email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the user's mobile number.
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * Updates the user's mobile number.
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}