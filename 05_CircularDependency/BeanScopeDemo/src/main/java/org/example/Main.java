package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order = context.getBean(OrderService.class);
        OrderService order2 = context.getBean(OrderService.class);

       // OrderService order3 = new OrderService();

        System.out.println(order ==  order2);   //references to same bean/object in singleton and diff. in prototype Bean Scope

    //Bean Scopes:
        //by default scope is singleton
    //1. Singleton - one bean per one Bean Definition. Returns Single object only in both via getBean or via DI
    //2. Prototype - Returns new objects/beans per request everytime new

    //When to use which:
    // if we want stateful data, use prototype
    // if we don't have diff states we define it as singleton
    //Other scopes: Request, Session, Application
    }
}