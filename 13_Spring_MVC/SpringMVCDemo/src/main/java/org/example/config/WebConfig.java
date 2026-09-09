package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/*
 * WebConfig is the main configuration class for our Spring MVC application.
 *
 * It tells Spring:
 * 1. This class contains configuration.
 * 2. Where Spring should search for components.
 * 3. Enable Spring MVC features.
 */

@Configuration
// Marks this class as a Spring configuration class.
// Spring uses it to create and configure the application context.

@ComponentScan(basePackages = "org.example")
// Tells Spring to scan the "org.example" package and its sub-packages
// for classes annotated with @Component, @Service, @Repository, @Controller, etc.

@EnableWebMvc
// Enables Spring MVC configuration and features.
// It sets up components required for request handling, controllers,
// message conversion, handler mappings, etc.

public class WebConfig {

}