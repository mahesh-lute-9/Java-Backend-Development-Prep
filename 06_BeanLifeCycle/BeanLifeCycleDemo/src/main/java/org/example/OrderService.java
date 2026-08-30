package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderBean") // Changes the default bean name from "orderService" to "orderBean"
public class OrderService {

    @Autowired
    private PaymentService paymentService;

//    // Constructor injection
//    public OrderService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder() {
        System.out.println("Order Placed");
    }
}

/*
 * Bean Definition:
 *
 * beanName   : orderBean       // Custom bean name
 * beanClass  : OrderService
 * scope      : singleton
 * lazy       : false
 * dependency : paymentService
 *
 * Spring first creates Bean Definitions for the beans.
 * These definitions contain metadata about how each bean should be created
 * and managed.
 *
 * Spring is dependency-aware and creates beans according to their
 * dependency relationships.
 */