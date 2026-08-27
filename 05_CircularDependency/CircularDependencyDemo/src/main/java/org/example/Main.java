package org.example;

import org.example.simple.A;
import org.example.simple.B;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

/* Circular dependency usually indicates a problematic design.
With constructor injection, dependencies must be provided
at the time the object is created.

If A depends on B and B depends on A:

A → B → A

Spring cannot create A without B,
and cannot create B without A.

Therefore, constructor injection cannot resolve
this circular dependency.
 */


    //So here what Spring IoC container can Do is inject dependency via field or setter method so that
    //1. Create OrderService empty obj
    //2. Create PaymentService empty obj
    //3. Inject paymentService to OrderService
    //4. Inject orderService to PaymentService


    //So here what IoC container does is:
    //1. Create A --> OrderService
    //2. Inject its dependency
    //3. Create B --> PaymentService
    //4. Inject Dependency
    //so Spring uses reference concept so basically in Spring this works,
    //but we,Avoid this type of thing in SpringBoot, from 2.6 SpringBoot is deprecated this thing
    //spring.main.allow-circular-reference : false --> by default in SpringBoot
    }
}