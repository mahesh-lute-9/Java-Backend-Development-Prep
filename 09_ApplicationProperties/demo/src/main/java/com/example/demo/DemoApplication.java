package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
// Combines @Configuration, @EnableAutoConfiguration and @ComponentScan.
// It tells Spring Boot how to configure and start the application.
public class DemoApplication {

	public static void main(String[] args) {

		// Starts the Spring Boot application and creates the Spring container
		// (ApplicationContext), where Spring manages all the beans.
		SpringApplication.run(DemoApplication.class, args);

//     ApplicationContext context =
//           SpringApplication.run(DemoApplication.class, args);
//
//     // Gets the PaymentGateway bean from the Spring container.
//     // Spring has already created and configured this object.
//     PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);

//     // These values can be changed manually through the bean.
//     paymentGateway.setType("Paytm");
//     paymentGateway.setRetryCount(5);

//     System.out.println(paymentGateway.getRetryCount());
//     System.out.println(paymentGateway.getType());
//     System.out.println(paymentGateway.isEnabled());
//     System.out.println(paymentGateway.getTimeout());

		// Instead of manually getting the bean and calling print(),
		// ApplicationRunner/CommandLineRunner can run startup logic automatically.
		//paymentGateway.print();

	}
}


// Topics covered in this project:
//
// 1. Spring Boot Configuration
//    - application.properties
//    - Externalized configuration
//
// 2. @Value
//    - Injects individual configuration values into a bean.
//
// 3. @ConfigurationProperties
//    - Binds a group of related configuration values to a Java object.
//
// 4. Starting a Spring Boot application
//    - SpringApplication.run() starts the application and creates the ApplicationContext.
//
// 5. ApplicationRunner
//    - Runs custom logic automatically after the Spring application starts.
//
// 6. CommandLineRunner
//    - Similar to ApplicationRunner, but receives command-line arguments as String... args.