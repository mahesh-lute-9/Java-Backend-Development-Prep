package org.example;

//import org.springframework.stereotype.Component;

//@Component
public class OrderService {

    public OrderService(){
        System.out.println("Order Service created");
    }

    public void orderPlaced(){
        System.out.println("Order Placed");
    }
}
