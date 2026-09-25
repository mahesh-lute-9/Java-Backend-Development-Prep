package com.example.crudSpringBootDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// common behavior helper class
// used for REST based application
//@ControllerAdvice
// used for returning web pages like HTML
//@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.status(
                HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}


// IN JAVA THERE'RE two types of exceptions runtime and compile time
// exception class --> root class