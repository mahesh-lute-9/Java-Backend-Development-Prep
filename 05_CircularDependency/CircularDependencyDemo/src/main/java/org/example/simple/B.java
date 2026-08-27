package org.example.simple;

public class B {

    private final A a;

    public B(){
        System.out.println("A created");
        this.a = new A();
    }
}
