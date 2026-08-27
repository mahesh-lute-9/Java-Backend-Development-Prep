package org.example.simple;

public class A {

    private final B b;

    public A(){
        System.out.println("B created");
        this.b = new B();
    }
}
