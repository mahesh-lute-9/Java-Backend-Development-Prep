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