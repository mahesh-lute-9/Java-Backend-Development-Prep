package org.example.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Qualifier("cp")    //changing the name of bean by default it is always of class name in camelCase notation
public class CardPayment implements PaymentService{

    @Override
    public void pay(){
        System.out.println("Paying via card");
    }
}
