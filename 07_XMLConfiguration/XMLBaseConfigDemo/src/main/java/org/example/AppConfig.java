package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public OrderService orderServiceBean(){
        return new OrderService();
    }

    @Bean
    public OrderService orderServiceBean2(){
        return new OrderService();
    }

    //here it creates two beans of same type
}
