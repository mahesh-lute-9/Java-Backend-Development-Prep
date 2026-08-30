package org.example;

import org.springframework.stereotype.Component;

@Component
public class B {

    private A a;

    // Constructor injection is avoided here
    // to prevent a circular dependency during object creation
//    public B(A a) {
//        this.a = a;
//    }

    // A is injected after B is created
    // This helps break the circular dependency
    public void setA(A a) {
        this.a = a;
    }
}