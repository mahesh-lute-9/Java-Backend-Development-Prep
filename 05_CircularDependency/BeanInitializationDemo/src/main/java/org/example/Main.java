package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.management.InvalidApplicationException;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
       // System.out.println("Payment Service not started yet");
        order.placeOrder();
  //      PaymentService payment = context.getBean(PaymentService.class);

        //Default Initialization is Eager.
        //To make it Lazy we use @Lazy Annotation
        //If scope is singletone then Eager Initialization happens, if we want lazy initialization then we use @Lazy
        //If scope is prototype then Lazy initialization happens, but here there is no option to change

        //WHY? Spring applications try to create most object at the starting
        //because fail fast
        //to make all the applications bean initialization lazy: spring.main.lazy-initialization = true
        //even in this if we want to make someone eager then we use @Lazy("false")
    }
}