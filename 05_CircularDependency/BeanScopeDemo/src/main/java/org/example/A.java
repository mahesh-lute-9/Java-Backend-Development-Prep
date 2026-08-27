package org.example;

import org.springframework.stereotype.Component;

@Component
public class A {

    private final OrderService orderService;

    public A(OrderService orderService){
        this.orderService = orderService;
    }
}
