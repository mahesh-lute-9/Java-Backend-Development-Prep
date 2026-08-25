package org.example;

import org.example.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class OrderService {

    //private PaymentService paymentService = new PaymentService();  //tightly coupled
    //@Autowired      //field injection
    private final PaymentService paymentService;


    //this is most used type of DI, when we use this it is not a necessary to write @Autowired annotation here Spring gets to know without it, cause here is only one constructor
//    @Autowired      //used to wire the dependency from PaymentService to OrderService via constructor
//    public OrderService(@Qualifier("upiPayment")PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    @Autowired
    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }



    /*
    By using the Constructor Injection we can:
        1.wire dependency at the time of Object creation
        2.final can be used
        3.Easy to test the class(UNIT test)
     */

//    @Autowired  //using a setter method to inject dependency
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order Placed");
    }
}


//Types of DI
/*
1. Constructor Injection
2. Setter Injection
3. Field Injection
 */


//Steps for ApplicationContext(IoC container)
/*
1. Spring start the container
2. Spring reads AppConfig.java
3. Spring processes @ComponentScan
4. Spring finds @Component classes
5. Spring creates Bean Definitions --> before creating Objects it needs like, Bean name, Bean class, Scope, Dependency using BeanDefintion inteface
6. Spring starts creating objects/beans
7. Our Application uses these Beans
 */