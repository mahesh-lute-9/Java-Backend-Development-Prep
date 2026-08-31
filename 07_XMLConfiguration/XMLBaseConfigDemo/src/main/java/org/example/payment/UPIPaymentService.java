package org.example.payment;

// This class provides the UPI-specific implementation
// of the PaymentService interface.
//
// PaymentService defines WHAT a payment service should do:
//     pay()
//
// UPIPaymentService defines HOW the payment is performed:
//     through UPI.
//
// Because we are practicing XML-based configuration,
// we don't need @Component here.
// Spring will be told about this class through the XML file.
public class UPIPaymentService implements PaymentService {

    // @Override tells Java that this method is implementing
    // the pay() method declared in PaymentService.
    @Override
    public void pay() {
        System.out.println("Paying via UPI");
    }
}