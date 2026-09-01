package org.example;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;

    // don't need to add @Autowire annotation as it is constructor injection it has only one constructor
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.pay();

        System.out.println("Order Placed");
    }
}
