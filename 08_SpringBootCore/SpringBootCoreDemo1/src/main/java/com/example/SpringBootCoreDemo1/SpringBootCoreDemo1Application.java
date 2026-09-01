package com.example.SpringBootCoreDemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

// ------------------------------------------------------------
// @SpringBootApplication
// ------------------------------------------------------------
//
// @SpringBootApplication is a convenience annotation that combines
// three important annotations:
//
//     @SpringBootConfiguration
//     @EnableAutoConfiguration
//     @ComponentScan
//
// So instead of writing all three separately, we normally use:
//
//     @SpringBootApplication
//
// In simple terms:
//
// @SpringBootConfiguration → tells Spring Boot that this is a
//                            configuration class.
//
// @EnableAutoConfiguration → asks Spring Boot to automatically
//                            configure required infrastructure based
//                            on the dependencies present in the project.
//
// @ComponentScan → tells Spring to scan packages for classes such as
//                   @Component, @Service, @Repository, @Controller, etc.
//
// NOTE:
// @SpringBootApplication is not literally the implementation of all
// three annotations itself. It is meta-annotated with them.
@SpringBootApplication
public class SpringBootCoreDemo1Application {

	// ------------------------------------------------------------
	// SpringApplication.run()
	// ------------------------------------------------------------
	//
	// SpringApplication.run() starts the Spring Boot application.
	//
	// It creates and prepares the Spring ApplicationContext
	// (IoC Container), performs component scanning, applies
	// auto-configuration, creates Beans, performs dependency
	// injection, and finally makes the application ready.
	//
	// run() actually returns ConfigurableApplicationContext.
	//
	// ConfigurableApplicationContext is a sub-interface of
	// ApplicationContext, so we can store the returned object
	// using an ApplicationContext reference.
	public static void main(String[] args) {

		// SpringApplication.run() starts Spring Boot and returns
		// the ApplicationContext.
		//
		// 'context' is our reference to the Spring IoC Container.
		//
		// We can use this context to ask Spring for Beans.
		ApplicationContext context =
				SpringApplication.run(SpringBootCoreDemo1Application.class, args);


		// ------------------------------------------------------------
		// Getting a Bean from the Spring IoC Container
		// ------------------------------------------------------------
		//
		// OrderService is annotated with @Component.
		//
		// Therefore, component scanning detects OrderService and
		// Spring creates and manages its Bean.
		//
		// getBean(OrderService.class) asks the IoC Container:
		//
		// "Give me the OrderService Bean that you are managing."
		//
		// We are NOT creating the object ourselves using 'new'.
		OrderService orderService = context.getBean(OrderService.class);

		// Calling the method on the Spring-managed OrderService Bean.
		//
		// OrderService has a dependency on PaymentService.
		// Spring already injected PaymentService through the
		// OrderService constructor.
		orderService.placeOrder();


		// ------------------------------------------------------------
		// @Bean
		// ------------------------------------------------------------
		//
		// @Bean is used when we want to explicitly tell Spring:
		//
		// "Call this method and register the returned object
		// as a Bean in the IoC Container."
		//
		// For example:
		//
		// @Bean
		// public UserService getUserServiceBean() {
		//     return new UserService();
		// }
		//
		// This is especially useful when:
		// 1. The class is created by us but we want explicit
		//    configuration.
		// 2. The class comes from an external library and we
		//    cannot add @Component to it.


		// ------------------------------------------------------------
		// @SpringBootConfiguration
		// ------------------------------------------------------------
		//
		// @SpringBootConfiguration identifies this class as a
		// Spring Boot configuration class.
		//
		// Conceptually, it plays a role similar to a main
		// configuration class in traditional Spring applications.
		//
		// @SpringBootApplication already includes it, so we normally
		// don't write @SpringBootConfiguration separately.


		// ------------------------------------------------------------
		// @ComponentScan
		// ------------------------------------------------------------
		//
		// @ComponentScan tells Spring where to look for component
		// classes such as:
		//
		// @Component
		// @Service
		// @Repository
		// @Controller
		//
		// By default, component scanning starts from the package
		// containing this configuration class and scans its
		// sub-packages.
		//
		// That's why it is a common practice to keep the main
		// Spring Boot application class in the root/parent package.
		//
		// Example:
		//
		// com.example.SpringBootCoreDemo1          ← main package
		//             |
		//             ├── OrderService
		//             ├── PaymentService
		//             └── controller
		//
		// All of these can be discovered automatically.


		// ------------------------------------------------------------
		// @EnableAutoConfiguration
		// ------------------------------------------------------------
		//
		// @EnableAutoConfiguration tells Spring Boot to attempt
		// automatic configuration based on:
		//
		// 1. Dependencies available on the classpath
		// 2. Existing Beans/configuration
		// 3. Conditions defined by Spring Boot's auto-configuration
		//
		// Spring Boot has many auto-configuration classes.
		// It doesn't blindly create everything.
		//
		// Auto-configurations are applied only when their conditions
		// are satisfied.
		//
		// Two important conditional annotations you will commonly see:
		//
		// @ConditionalOnClass
		// → Apply this configuration when a particular class is
		//   available on the classpath.
		//
		// @ConditionalOnMissingBean
		// → Apply/create the default configuration only when the
		//   application has not already defined a matching Bean.
		//
		// This allows Spring Boot to provide sensible defaults while
		// still allowing developers to override them.


		// ------------------------------------------------------------
		// @Bean examples
		// ------------------------------------------------------------
		//
		// Creating a Bean for a class from an external library:
		//
		// @Bean
		// public JsonParser getJsonParserBean() {
		//     return new BasicJsonParser();
		// }
		//
		// We cannot normally add @Component to BasicJsonParser because
		// its source code belongs to an external library.
		//
		// Therefore, @Bean allows us to manually create the object
		// and let Spring manage the returned object as a Bean.
	}

	// ------------------------------------------------------------
	// Explicit Bean Configuration
	// ------------------------------------------------------------
	//
	// @Bean methods can be declared inside a configuration class.
	//
	// Example:
	//
	// @Bean
	// public JsonParser getJsonParserBean() {
	//     return new BasicJsonParser();
	// }
	//
	// Spring calls this method during configuration and registers
	// the returned object as a Bean.
	//
	// @Bean
	// public UserService getUserServiceBean() {
	//     return new UserService();
	// }
}


// ================================================================
// IMPORTANT SPRING BOOT CONCEPTS TO REVISE
// ================================================================
//
// @SpringBootApplication
//        ↓
// Combines:
//
// @SpringBootConfiguration
//        ↓
// Identifies the main configuration class.
//
// @EnableAutoConfiguration
//        ↓
// Lets Spring Boot configure infrastructure automatically based
// on the application's dependencies and conditions.
//
// @ComponentScan
//        ↓
// Finds classes annotated with @Component, @Service,
// @Repository, @Controller, etc.
//
//
// ================================================================
// WHAT HAPPENS AFTER SpringApplication.run()?
// ================================================================
//
// main()
//   ↓
// SpringApplication.run()
//   ↓
// Spring Boot starts
//   ↓
// Creates the ApplicationContext / IoC Container
//   ↓
// Reads configuration
//   ↓
// Performs component scanning
//   ↓
// Finds @Component / @Service / @Repository / @Controller etc.
//   ↓
// Processes auto-configuration
//   ↓
// Creates required Beans
//   ↓
// Resolves dependencies
//   ↓
// Performs Dependency Injection
//   ↓
// Application becomes ready
//
//
// ================================================================
// @SpringBootApplication SOURCE CONCEPT
// ================================================================
//
// Conceptually:
//
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan
//
// @SpringBootApplication
//     ├── @SpringBootConfiguration
//     ├── @EnableAutoConfiguration
//     └── @ComponentScan
//
// This is why @SpringBootApplication is usually placed on the
// main application class.
//
// ================================================================
// CUSTOM ANNOTATIONS
// ================================================================
//
// Java allows us to create our own annotations.
//
// Basic example:
//
// @Target(ElementType.TYPE)
// @Retention(RetentionPolicy.RUNTIME)
// public @interface MyAnnotation {
// }
//
// @Target
// → Defines where the annotation can be used.
//
// @Retention
// → Defines how long the annotation should be available.
//
// @RetentionPolicy.RUNTIME
// → Keeps the annotation available at runtime, allowing frameworks
//   such as Spring to inspect it using reflection.
//
// We'll cover custom annotations separately after understanding
// the built-in Spring annotations properly.