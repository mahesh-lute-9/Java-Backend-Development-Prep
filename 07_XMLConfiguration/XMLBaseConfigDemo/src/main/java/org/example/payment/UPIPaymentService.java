package org.example.payment;

public class UPIPaymentService implements PaymentService{
    @Override
    public void pay() {
        System.out.println("Paying via UPI");
    }
}
