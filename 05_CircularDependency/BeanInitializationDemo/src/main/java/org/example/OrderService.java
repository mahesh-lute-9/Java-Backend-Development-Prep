package org.example;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class OrderService {

    private final PaymentService paymentService;

    public OrderService(@Lazy PaymentService paymentService){           //we can use @Lazy here it tells like create OrderService but do not create its dependency
        this.paymentService = paymentService;

        // it gets proxy here till we call it
    }

    public void placeOrder(){
        paymentService.pay();

        System.out.println("Order Placed");
    }

    public void getOrderDetails(){
        System.out.println("Order Details are: ");
    }
}
