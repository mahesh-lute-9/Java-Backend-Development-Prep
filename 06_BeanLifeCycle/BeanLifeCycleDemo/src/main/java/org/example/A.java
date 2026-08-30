package org.example;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class A {

    private B b;

    // B is injected through the constructor
    public A(B b) {
        this.b = b;
    }

    // Called by Spring after the bean is created and dependencies are injected
    @PostConstruct
    public void setB() {
        b.setA(this);
    }
}

// Resolving circular dependency using @PostConstruct