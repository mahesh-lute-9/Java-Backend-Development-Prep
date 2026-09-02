package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
// Registers this class as a Spring bean so it can be injected into other classes.
@ConfigurationProperties("payment-property")
// Binds all properties starting with "payment-property"
// from application.properties to the fields of this class.
public class PaymentProperties {

    private String type;
    private int retryCount;
    private boolean enabled;
    private int timeout;

    // payment-property.type → type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // payment-property.retry-count → retryCount
    // Spring Boot's relaxed binding handles kebab-case → camelCase.
    public int getRetryCount() {
        return retryCount;
    }

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    // payment-property.enabled → enabled
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // payment-property.timeout → timeout
    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}