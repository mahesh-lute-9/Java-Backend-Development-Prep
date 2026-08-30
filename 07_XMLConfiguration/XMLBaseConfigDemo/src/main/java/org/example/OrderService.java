package org.example;

//import org.springframework.stereotype.Component;

import org.example.payment.PaymentService;

//@Component
public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }


//    public void setPaymentServiceBean(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void orderPlaced(){
        paymentService.pay();

        System.out.println("Order Placed");
    }
}
