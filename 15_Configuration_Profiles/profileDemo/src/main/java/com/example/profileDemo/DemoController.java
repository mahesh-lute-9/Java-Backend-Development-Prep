package com.example.profileDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/demo")
public class DemoController {

    // if we made it hardcoded: here every time we have to change the codebase to change the message
    //private String message = "LOCAL: Hello, welcome to my application";

    @Value("${app.welcome.message}")
    private String message;

    // hardcoding the database properties, these can varies as the environment changes. also we it can be leak in version control systems
//    String dbURL = "jdbc:postgresql://localhost:5432/student_crud_db";
//    String username = "postgres";
//    String password = "postgres123";

    @GetMapping("/greet")
    public ResponseEntity<String> greet(){

        return ResponseEntity.ok(message);
    }
}
