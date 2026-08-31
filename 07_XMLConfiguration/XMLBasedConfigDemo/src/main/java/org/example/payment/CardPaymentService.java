package org.example.payment;

// This class provides the actual implementation of PaymentService.
//
// PaymentService only defines WHAT a payment service should do
// (pay()).
//
// CardPaymentService defines HOW the payment is done.
//
// In XML-based Spring configuration, this class does NOT need
// @Component. We will tell Spring about this class in the XML file.
public class CardPaymentService implements PaymentService {

    // @Override tells Java that we are implementing the
    // pay() method defined in the PaymentService interface.
    @Override
    public void pay() {
        System.out.println("Paying via Card");
    }
}