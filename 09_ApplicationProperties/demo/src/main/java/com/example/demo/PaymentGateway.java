package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// Spring creates and manages PaymentGateway as a bean.
public class PaymentGateway {

    private PaymentProperties paymentProperties;

    public PaymentGateway(PaymentProperties paymentProperties) {
        // Spring automatically injects the PaymentProperties bean here.
        this.paymentProperties = paymentProperties;
    }

    // Only getters → PaymentGateway can read configuration,
    // but cannot directly modify it. This keeps the configuration controlled.
    public String getType() {
        return paymentProperties.getType();
    }

    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }

    public boolean isEnabled() {
        return paymentProperties.isEnabled();
    }

    public int getTimeout() {
        return paymentProperties.getTimeout();
    }


    public void print() {
        System.out.println(getRetryCount());
        System.out.println(getType());
        System.out.println(isEnabled());
        System.out.println(getTimeout());
    }


//    @Value("${paymentGateway.type:Razorpay}")
//    // Injects a single configuration value from application.properties.
//    private String type;
//
//    @Value("${paymentGateway.retry-count:3}")
//    // Uses 3 as the default value if paymentGateway.retry-count is missing.
//    private int retryCount;

//    public PaymentGateway(@Value("${paymentGateway.type}") String type,
//                          @Value("${paymentGateway.retry-count}") int retryCount) {
//        // @Value can also inject configuration values through the constructor.
//        this.type = type;
//        this.retryCount = retryCount;
//    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public int getRetryCount() {
//        return retryCount;
//    }
//
//    public void setRetryCount(int retryCount) {
//        this.retryCount = retryCount;
//    }

}