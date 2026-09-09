package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
 * WebConfig is the main configuration class for our Spring MVC + JSP project.
 *
 * It configures:
 * 1. Spring component scanning
 * 2. Spring MVC
 * 3. JSP view resolution
 * 4. Static resources such as CSS, JavaScript and images
 */

@Configuration
// Marks this class as a Spring configuration class.

@ComponentScan(basePackages = "org.example")
// Tells Spring to scan the org.example package and its sub-packages
// for components such as @Controller, @Service, @Repository, etc.

@EnableWebMvc
// Enables Spring MVC configuration and its required infrastructure.

public class WebConfig implements WebMvcConfigurer {


    @Bean
    public ViewResolver viewResolver() {

        /*
         * ViewResolver helps Spring MVC find the appropriate view
         * (JSP page) returned by a controller.
         *
         * Example:
         * Controller returns "home"
         *
         * Spring resolves it as:
         * WEB-INF/views/home.jsp
         */

        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();

        // Defines the folder where JSP files are stored.
        resolver.setPrefix("WEB-INF/views");

        // Defines the extension that will be added to the view name.
        resolver.setSuffix(".jsp");

        return resolver;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /*
         * Configures static resources such as:
         * CSS, JavaScript, images, fonts, etc.
         *
         * A request like:
         * /assets/style.css
         *
         * will be mapped to:
         * /assets/style.css
         */

        registry.addResourceHandler("/assets/**")
                .addResourceLocations("/assets/");
    }
}