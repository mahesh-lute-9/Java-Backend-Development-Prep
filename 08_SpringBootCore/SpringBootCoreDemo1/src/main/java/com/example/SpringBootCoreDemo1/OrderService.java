package com.example.SpringBootCoreDemo1;

import org.springframework.stereotype.Component;

// @Component tells Spring:
// "Create and manage an object of this class as a Spring Bean."
//
// During component scanning, Spring detects this class and creates
// an OrderService object inside the Spring IoC Container.
//
// Since OrderService has a constructor dependency on PaymentService,
// Spring will also look for a PaymentService Bean and inject it.
@Component
public class OrderService {

    // Dependency required by OrderService.
    //
    // OrderService cannot perform payment-related work by itself,
    // so it depends on PaymentService.
    private final PaymentService paymentService;

    // Constructor Injection
    //
    // Spring sees that the constructor requires a PaymentService.
    // If PaymentService is also a Spring Bean, Spring automatically
    // provides that Bean as the constructor argument.
    //
    // This is how Spring performs Dependency Injection (DI).
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void placeOrder(){

        // Calling the method of the injected PaymentService Bean.
        paymentService.pay();

        System.out.println("Order Placed");
    }
}
