package org.example;

import org.example.payment.PaymentService;

// @Component is commented because we are NOT using
// annotation-based component scanning in this project.
//
// With XML-based configuration, Spring will create this
// object through a <bean> definition in the XML file.

//@Component
public class OrderService {

    // OrderService depends on PaymentService.
    //
    // Notice that we are using the interface type here,
    // not CardPaymentService or UPIPaymentService.
    //
    // This means OrderService doesn't care HOW payment is made.
    // It only knows that a PaymentService can perform pay().
    private PaymentService paymentService;


    // Constructor Injection
    //
    // Spring will use this constructor to provide a
    // PaymentService object when creating OrderService.
    //
    // For example, Spring could inject:
    //
    //     CardPaymentService
    //
    // OR
    //
    //     UPIPaymentService
    //
    // depending on how we configure the XML.
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


//    // Setter Injection
//    //
//    // This is another way Spring can inject the dependency.
//    // Instead of passing PaymentService through the constructor,
//    // Spring can call this setter method after creating
//    // the OrderService object.
//
//    public void setPaymentServiceBean(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }


    // This method represents placing an order.
    public void orderPlaced() {

        // We don't create the payment object ourselves:
        //
        //     new CardPaymentService()
        //
        // or
        //
        //     new UPIPaymentService()
        //
        // Spring has already injected the required
        // PaymentService object into this class.
        paymentService.pay();

        System.out.println("Order Placed");
    }
}