package com.example.crudSpringBootDemo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

    public class UpdateStudentRequestDTO {

        @NotBlank(message = "Name cannot be null, empty or blank")
        @Size(
                min = 2,
                max = 50,
                message = "Student name must be between 2 and 50 characters"
        )
        private String name;


        @NotBlank(message = "Student email cannot be blank")
        @Email(message = "Student email must be valid")
        private String email;


        @NotNull(message = "Age is required")
        @Min(
                value = 18,
                message = "Student must be at least 18 years old"
        )
        private Integer age;


        @NotNull(message = "Roll number is required")
        private Integer rollNo;


        @NotBlank(message = "Subject is required")
        private String subject;


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


        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }


        public Integer getRollNo() {
            return rollNo;
        }

        public void setRollNo(Integer rollNo) {
            this.rollNo = rollNo;
        }


        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }}
