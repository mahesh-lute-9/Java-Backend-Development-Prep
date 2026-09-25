package com.example.crudSpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    @SpringBootApplication combines:

    1. @SpringBootConfiguration
    2. @EnableAutoConfiguration
    3. @ComponentScan

    Since this class is in:

        com.example.crudSpringBootDemo

    Spring automatically scans sub-packages such as:

        controller
        service
        repository
*/
@SpringBootApplication
public class CrudSpringBootDemoApplication {

	public static void main(String[] args) {

        /*
            SpringApplication.run() starts the application.

            High-level flow:

            main()
              ↓
            SpringApplication.run()
              ↓
            ApplicationContext
              ↓
            Component Scanning
              ↓
            Auto Configuration
              ↓
            Beans Created
              ↓
            JPA / DataSource Configuration
              ↓
            Embedded Server
        */

		SpringApplication.run(
				CrudSpringBootDemoApplication.class,
				args
		);
	}
}

// DTOs and Validations
// unlike JAVA, SpringBoot also uses default exception handler, generic