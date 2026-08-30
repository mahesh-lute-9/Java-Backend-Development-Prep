package org.example.payment;

public class CardPaymentService implements PaymentService{

    @Override
    public void pay(){
        System.out.println("Paying via Card");
    }
}
