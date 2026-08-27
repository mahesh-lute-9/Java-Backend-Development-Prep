package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")  //@Scope annotation used to declare the scope of Bean. singleton Eagerly Initialized
//@Scope("prototype")    //prototype creates Lazy initialization
public class OrderService {

    public OrderService(){
        System.out.println("OrderService created");
    }

    public void pay(){
        System.out.println("Payment Done");
    }
}
