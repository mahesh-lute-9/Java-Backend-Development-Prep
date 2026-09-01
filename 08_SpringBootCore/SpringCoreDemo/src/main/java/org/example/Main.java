package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();
    }
}


//in spring core there are step which are compulsory to do before managing all this
// to make it easier, we come up with the SpringBoot
// Spring MVC - web app
// til now in Spring Core we're managing the beans using AppConfig file in which @Configuraion & @ComponentScan was doing work
// dependencies were gets added via pom.xml under <dependencies></dependencies> tag
// for external libraries we were creating those class's beans via @Bean by returning the class by method so that we were able to create the beans of any other classes(JAR, external library, etc)