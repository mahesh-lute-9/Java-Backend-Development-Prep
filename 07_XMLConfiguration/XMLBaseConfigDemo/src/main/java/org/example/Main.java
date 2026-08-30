package org.example;

import org.example.payment.PaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");          //ClassPathXMLApplicationContext used for XML based configurations

        // get bean by type
//        OrderService orderService = context.getBean(OrderService.class);      // this is one of way to get the bean
//        orderService.orderPlaced();
        // this will only work with single bean definition

        // get bean by id/name
//        OrderService orderService = (OrderService) context.getBean("orderService");         // this is also a way to get the bean
//        orderService.orderPlaced();
        // this will work even if we have multiple beans of same type, we just have to call them accordingly

        // passing both the parameters id and as well as the reflection of that class
        OrderService orderService =
                context.getBean("orderService", OrderService.class);

//        PaymentService paymentService =
//                context.getBean("paymentService", PaymentService.class);

        orderService.orderPlaced();
        // this is best way to get bean


    }
}