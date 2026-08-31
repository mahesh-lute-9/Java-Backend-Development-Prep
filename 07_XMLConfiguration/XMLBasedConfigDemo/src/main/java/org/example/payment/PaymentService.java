package org.example.payment;

// This interface defines the contract for payment operations.
//
// In simple terms:
// "Any class that wants to provide payment functionality
// must implement the pay() method."
//
// In XML-based Spring configuration, we don't need @Component here.
// Spring will be told which implementation class should become
// a bean through the XML configuration file.

//import org.springframework.stereotype.Component;

//@Component
public interface PaymentService {

    // The actual payment logic will be written by the class
    // that implements this interface.
    //
    // Example:
    // public class UpiPaymentService implements PaymentService {
    //     @Override
    //     public void pay() {
    //         ...
    //     }
    // }

    void pay();
}