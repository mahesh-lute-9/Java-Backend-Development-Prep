package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements ApplicationRunner /* CommandLineRunner */ {

    private PaymentGateway paymentGateway;

    public DemoRunner(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Runs automatically after the Spring Boot application starts.
        paymentGateway.print();
    }

//    @Override
//    public void run(String... args) throws Exception {
//        // CommandLineRunner receives command-line arguments as String values.
//        paymentGateway.print();
//    }
}