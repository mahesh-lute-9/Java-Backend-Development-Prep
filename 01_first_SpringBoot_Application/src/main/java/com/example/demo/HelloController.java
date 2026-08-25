package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public static String hello(){
        return "Hello from Mahesh...";
    }

    @GetMapping("bye")
    public static String bye(){
        return "Thank You!! Bye";
    }

}
