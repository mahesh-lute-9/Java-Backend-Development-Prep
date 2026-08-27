package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

//    @Autowired
//    private OrderService orderService;

//    public PaymentService(OrderService orderService){
//        this.orderService = orderService;
//    }

    public void pay(){
        System.out.println("Payment Done");

        //Not it's responsibility also it's bad coding design practice
        //orderService.getOrderDetails();
    }
}
