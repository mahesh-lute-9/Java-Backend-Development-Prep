package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")   //declaring the package name to search within

public class AppConfig {

    @Bean
    public UserService getUserServiceBEan(){
        return new UserService();
    }   //bean created using @Bean -- Java based
}
