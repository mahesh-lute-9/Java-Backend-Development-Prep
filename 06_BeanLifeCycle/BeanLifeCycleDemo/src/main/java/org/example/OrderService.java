package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderBean") //--> we use this to change the bean name
public class OrderService {

    @Autowired
    private PaymentService paymentService;

//    public OrderService(PaymentService paymentService){
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){
        System.out.println("Order Placed");
    }
}


// Bean Definition
/*
    beanName : orderService --> orderBean(changed)
    beanClass : OrderService
    scope : singleton
    lazy : false
    dependency : paymentService
 */

// Spring creates all the Bean Definitions firstly
// So that it can know which objects have lazy initialization, and manage bean properly
// Spring creates bean by the dependency tree, it is dependency aware