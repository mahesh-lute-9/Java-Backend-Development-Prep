package com.example.SpringBootCoreDemo1;

import org.springframework.stereotype.Component;

// @Component tells Spring to detect this class during component scanning
// and create an object of PaymentService as a Spring Bean.
//
// Because PaymentService is a Bean, Spring can inject it into other
// Beans that depend on it, such as OrderService.
@Component
public class PaymentService {

    // Business logic related to making a payment.
    public void pay(){
        System.out.println("Payment Done");
    }
}
