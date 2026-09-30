package com.example.profileDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/demo")
public class DemoController {

    // if we made it hardcoded: here every time we have to change the codebase to change the message
    //private String message = "LOCAL: Hello, welcome to my application";

    @Value("${app.welcome.message}")  // this will be same either our config file .properties or .yml
    private String message;

    // hardcoding the database properties, these can varies as the environment changes. also it can be leaked in version control systems
//    String dbURL = "jdbc:postgresql://localhost:5432/student_crud_db";
//    String username = "postgres";
//    String password = "postgres123";

    @Value("${app.welcome.code}")
    private Integer code;

    @Value("${app.welcome.names}")
    private List<String> names;

    @GetMapping("/greet")
    public ResponseEntity<String> greet(){

        System.out.println(names);
        return ResponseEntity.ok(message + " + " + code);
    }
}
