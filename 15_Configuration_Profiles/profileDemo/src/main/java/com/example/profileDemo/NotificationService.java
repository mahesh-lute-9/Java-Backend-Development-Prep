package com.example.profileDemo;

public interface NotificationService {

    public String send();
}

// we are implementing this method from diff classes and while running controller gets confused which bean to choose & it throws error/exception:

// Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

// but here @Primary and @Qualifier only used when there is one particular environment exists, so now we use @Profile annotation such as @Profile("dev") --> specifically