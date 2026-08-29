package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService order = context.getBean(OrderService.class);
//        order.placeOrder();
//
//        AppConfig config = context.getBean(AppConfig.class);
//        config.demo();

        UserService userService = context.getBean(UserService.class);
        userService.setBeanName("userBean2");

        // we think we are changing the name of bean but it is not getting changed cause we can't change it like this
        // it just gets printed
    }
}


// Spring Bean LifeCycle
/*
    1. IoC container Start
    2. Read Configuration      IoC manages configuration file, it creates bean of that also
    3. Read Bean Definition -- Metadata information
    4. Dependencies are Injected. if we are doing DI via constructor then where we'll be doing
        two things, 1. DI, 2. Object creation paralally. in othe type os DI it creates the object first then injects the Dependency
    5. Aware Interfaces are called --> we use these for logs, documentation, debugging

*/


// What are aware interfaces?
//