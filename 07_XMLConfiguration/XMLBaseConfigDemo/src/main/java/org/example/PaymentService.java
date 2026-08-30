package org.example;

//import org.springframework.stereotype.Component;

//@Component
public class PaymentService {

    private String type;
    private int retryCount;

    public PaymentService(String type, int retryCount){
        this.type = type;
        this.retryCount = retryCount;
    }

    public void pay(){
        System.out.println("Payment Done. Type of payment is "
                + type + " with "
                + retryCount
                + " counts"
        );
    }
}
