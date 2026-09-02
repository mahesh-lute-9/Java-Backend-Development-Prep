package org.example.payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier
//@Primary
public class UpiPayment implements PaymentService{

    @Override
    public void pay(){
        System.out.println("Paying by UPI");
    }
}
