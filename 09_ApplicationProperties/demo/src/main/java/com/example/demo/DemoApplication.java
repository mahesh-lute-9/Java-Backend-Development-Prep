package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(DemoApplication.class, args);

		PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);

//		paymentGateway.setType("Paytm");
//		paymentGateway.setRetryCount(5);

		System.out.println(paymentGateway.getRetryCount());
		System.out.println(paymentGateway.getType());
	}

}


// Explain Configurations in SpringBoot? What are the configs, which are they how?
// @Value Annotation?
// @ConfigurationProperties annotation?
//
