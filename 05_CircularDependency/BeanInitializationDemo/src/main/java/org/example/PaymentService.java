package org.example;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy //this annotation used to initialize the objects lazily, objects gets created when we ask for it

public class PaymentService {

    OrderService orderService;

    public PaymentService(OrderService orderService){
        this.orderService = orderService;
    }

    public void pay(){
        System.out.println("Payment Successful");

        orderService.getOrderDetails();
    }
}
