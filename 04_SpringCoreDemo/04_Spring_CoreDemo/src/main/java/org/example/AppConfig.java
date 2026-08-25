package org.example;

import org.example.payment.CardPayment;
import org.example.payment.PaymentService;
import org.example.payment.UpiPayment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("org.example")
//it is not necessary to write the package name in parameter
//if we don't write one it gets the one in which the AppConfig.java is present
//best practice it to write specifically

public class AppConfig {
    //We create Objects but manages the Spring IoC container
    //It is when we can't write @Component on classes
    //to do this we use @Bean Annotation
    //We can use @Component and @Beans both the Annotations
    //@Component is class wide Annotation
    //@Bean is method level Annotation used when using @Component gets difficult

    @Bean
    public User createUser(){
        return new User("Mahesh", 21);
    }

    @Bean
    public CartService createCartService(){ //this class is coming from external JAR files so we created the object/Bean using @Bean
        return new CartService();
    }

    @Bean//creating a Bean using @Bean Annotation, refused to create via @Component still works
    @Qualifier("cp")
    public PaymentService createCardService(){
        return new CardPayment();   //CardPayment is a type of PaymentService
    }

    @Bean
    //@Primary
    @Qualifier
    public  PaymentService createUpiService(){
        return new UpiPayment();
    }

//    @Bean
//    public  OrderService createOrderService(PaymentService paymentService){
//        return new OrderService(paymentService);    //it expects the object of PaymentService
//    }

    @Bean
    public OrderService createOrderService(@Qualifier("createUpiService")PaymentService paymentService){
        //PaymentService payment = createPaymentService();
        //OrderService order = new OrderService();
        //order.setPaymentService(paymentService);

        //return order;
        return  new OrderService(paymentService);   //here it injects bean of CardPayment cause bean of it been created
    }
}

//if we create two objects one using @Component and other s using @Bean
//Then the priority gets @Bean object
//Basically it gives priority to our manually created bean rather than Spring's own
//Basically we create the config file so that in that we can write most of our driver code so that
//Our main remains clean as that is our entry point of our application

//ApplicationContext is a super interface which is used for IoC Container