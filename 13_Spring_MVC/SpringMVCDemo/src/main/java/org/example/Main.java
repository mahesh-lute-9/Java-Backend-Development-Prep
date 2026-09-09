package org.example;

import org.example.config.*;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

/*
 * Main class:
 *
 * This is where we manually start the embedded Tomcat server
 * and connect it with our Spring MVC application.
 *
 * Flow:
 *
 * Client Request
 *       ↓
 *     Tomcat
 *       ↓
 * DispatcherServlet
 *       ↓
 * Spring MVC
 *       ↓
 *   Controller
 *       ↓
 *    Service
 *       ↓
 *   Repository
 */

public class Main {

    public static void main(String[] args) throws LifecycleException {

        // ============================================================
        // 1. CREATE AND CONFIGURE TOMCAT
        // ============================================================

        // Create an embedded Tomcat server.
        Tomcat tomcat = new Tomcat();

        // Set the port on which the server will listen.
        tomcat.setPort(8080);

        // Initializes the Tomcat connector.
        tomcat.getConnector();


        // Define the application context path.
        // "" means our application will run from the root:
        // http://localhost:8080/
        String contextPath = "";

        // Define the directory that will act as the web application's
        // document base.
        String baseDoc = new File("src/main/webapp").getAbsolutePath();

        // Add our application context to Tomcat.
        Context context = tomcat.addContext(contextPath, baseDoc);


        // ============================================================
        // 2. CREATE SPRING IOC CONTAINER
        // ============================================================

        /*
         * AnnotationConfigWebApplicationContext is the Spring
         * ApplicationContext used for a web application.
         *
         * It manages Spring beans such as:
         * Controller, Service, Repository, etc.
         */
        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();

        // Register our Spring MVC configuration class.
        springContext.register(WebConfig.class);


        // ============================================================
        // 3. CREATE DISPATCHER SERVLET
        // ============================================================

        /*
         * DispatcherServlet is the Front Controller of Spring MVC.
         *
         * Every incoming request is first received by the
         * DispatcherServlet, which then finds the appropriate
         * controller and method to handle the request.
         */
        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(springContext);


        // Register DispatcherServlet with Tomcat.
        Tomcat.addServlet(
                context, "dispatcherServlet", dispatcherServlet);

        // Map DispatcherServlet to "/" so that it handles
        // incoming requests for the application.
        context.addServletMappingDecoded(
                "/", "dispatcherServlet");


        // ============================================================
        // 4. START TOMCAT
        // ============================================================

        tomcat.start();

        System.out.println("Tomcat started on port 8080");

        // Keep the server running and wait for requests.
        tomcat.getServer().await();


        /*
         * ============================================================
         * SPRING MVC INTERVIEW QUESTIONS & ANSWERS
         * ============================================================
         *
         * Q1. What is Spring MVC?
         *
         * A:
         * Spring MVC is a web framework of the Spring Framework
         * used to build web applications and REST APIs using the
         * Model-View-Controller design pattern.
         *
         *
         * Q2. What is DispatcherServlet?
         *
         * A:
         * DispatcherServlet is the Front Controller of Spring MVC.
         * It receives incoming HTTP requests and delegates them
         * to the appropriate controller.
         *
         *
         * Q3. What is the role of WebConfig?
         *
         * A:
         * WebConfig is used to configure Spring MVC and define
         * component scanning and other MVC-related configuration.
         *
         *
         * Q4. What is an IoC Container?
         *
         * A:
         * The IoC (Inversion of Control) container creates,
         * manages, and injects Spring beans and their dependencies.
         *
         *
         * Q5. What is Dependency Injection?
         *
         * A:
         * Dependency Injection means that an object receives its
         * required dependencies from Spring instead of creating
         * them manually.
         *
         *
         * Q6. What is the difference between @Controller and
         * @RestController?
         *
         * A:
         * @Controller is generally used for MVC applications
         * that return views, while @RestController is used mainly
         * for REST APIs and returns data directly in the response body.
         *
         *
         * Q7. What does @RequestBody do?
         *
         * A:
         * @RequestBody converts the HTTP request body, such as JSON,
         * into a Java object.
         *
         *
         * Q8. What does @PathVariable do?
         *
         * A:
         * @PathVariable extracts a value from the URL and passes
         * it to the controller method.
         *
         *
         * Q9. Why do we use ResponseEntity?
         *
         * A:
         * ResponseEntity gives us control over the HTTP response,
         * including the response body and HTTP status code.
         *
         *
         * Q10. What is @ComponentScan?
         *
         * A:
         * @ComponentScan tells Spring which packages to scan for
         * classes annotated with @Component, @Service,
         * @Repository, @Controller, etc.
         *
         *
         * Q11. What does @EnableWebMvc do?
         *
         * A:
         * @EnableWebMvc enables Spring MVC configuration and
         * registers the required MVC infrastructure.
         *
         *
         * Q12. Why is Tomcat required?
         *
         * A:
         * Tomcat acts as the servlet container and web server that
         * receives HTTP requests and runs our web application.
         *
         *
         * Q13. What is the request flow in this project?
         *
         * A:
         *
         * Client
         *   ↓
         * Tomcat
         *   ↓
         * DispatcherServlet
         *   ↓
         * Controller
         *   ↓
         * Service
         *   ↓
         * Repository
         *   ↓
         * Response
         *
         *
         * Q14. What is the role of Service and Repository layers?
         *
         * A:
         * Service handles business logic, while Repository is
         * responsible for data access and data management.
         *
         *
         * Q15. Why use Constructor Injection?
         *
         * A:
         * Constructor Injection makes dependencies explicit and
         * allows Spring to provide them automatically when creating
         * the object.
         */
    }
}