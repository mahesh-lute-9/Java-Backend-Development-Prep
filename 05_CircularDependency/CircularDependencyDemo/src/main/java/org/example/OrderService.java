package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private PaymentService paymentService;

//    public OrderService(PaymentService paymentService){
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){
        paymentService.pay();

        //call here now PaymentService is not dependent on OrderService
        getOrderDetails();

        System.out.println("Order Placed");
    }

    public void getOrderDetails(){
        System.out.println("Order Details: ");
    }
}
