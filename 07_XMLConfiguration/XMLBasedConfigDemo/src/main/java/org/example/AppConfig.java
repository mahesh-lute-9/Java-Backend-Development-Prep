//package org.example;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//
//// @Configuration tells Spring that this class contains
//// configuration information and bean definitions.
//
//@Configuration
//
//
//// @ComponentScan tells Spring to scan the specified package
//// for classes annotated with @Component, @Service, @Repository,
// and other stereotype annotations.
//
//@ComponentScan
//public class AppConfig {
//
//
//    // @Bean tells Spring:
//    // "Call this method and manage the returned object as a Spring bean."
//
//    @Bean
//    public OrderService orderServiceBean(){
//        return new OrderService();
//    }
//
//
//    // This creates ANOTHER bean of the same type: OrderService.
//
//    @Bean
//    public OrderService orderServiceBean2(){
//        return new OrderService();
//    }
//
//
//    // Here we have two different Spring beans,
//    // but both beans are of the same type:
//
//    //     orderServiceBean  -> OrderService
//    //     orderServiceBean2 -> OrderService
//
//    // So Spring's container contains two OrderService objects.
//
//    // This is important when we later learn about
//    // multiple beans of the same type and @Qualifier / @Primary.
//}