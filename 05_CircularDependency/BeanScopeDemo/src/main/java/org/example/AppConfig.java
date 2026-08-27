package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public OrderService getOrder(){
        return new OrderService();
    }

    //Exists one bean/object per bean definition in singleton
    @Bean
    public OrderService getOrder2(){
        return new OrderService();
    }
}
