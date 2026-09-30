package com.example.profileDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfileDemoApplication.class, args);
	}

}



// Environments: Local, Dev, QA/staging, prod

// code --> main logic (Do not change)
// Configurations --> Do change

// configuration files - .properties, .yaml or external configurations
// .properties files use dotted/flat naming convention with key=value pairs
// .yml here tge configurations gets stored in tree like structure
// if we have both .yml and .properties config file then our SpringBoot prefers the .properties file as default
// profiling - making diff. .properties files for diff environments like: application-{profile}.properties

// HOW WE CAN ADD configurations EXTERNALLY
// Commandline, environment variables, CI/CD pipeline, kubernates, OS

// via commandline we use :  mvn spring-boot:run -Dspring-boot.run.profiles=staging(profile specific)
// here your maven should work properly, if it installed locally it would be better

