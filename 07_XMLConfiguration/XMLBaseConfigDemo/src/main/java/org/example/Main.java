package org.example;

import org.example.payment.PaymentService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        // ClassPathXmlApplicationContext is used when our Spring
        // configuration is written in an XML file.
        //
        // "AppConfig.xml" is the XML configuration file that tells
        // Spring which beans to create and how their dependencies
        // should be connected.
        //
        // When this line executes, Spring:
        // 1. Creates the Spring container.
        // 2. Reads AppConfig.xml.
        // 3. Creates the configured beans.
        // 4. Injects their dependencies.
        // 5. Calls configured initialization methods.
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("AppConfig.xml");


        // =========================================================
        // 1. GET BEAN BY TYPE
        // =========================================================

        // Spring can find a bean based on its class/type.
        //
        // OrderService orderService =
        //         context.getBean(OrderService.class);
        //
        // This is convenient, but it works when Spring can find
        // exactly ONE suitable bean for that type.
        //
        // If multiple OrderService beans exist, Spring cannot
        // decide which one you mean and this lookup can fail.


//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.orderPlaced();


        // =========================================================
        // 2. GET BEAN BY ID / NAME
        // =========================================================

        // We can also retrieve a bean using the id/name defined
        // in the XML configuration.
        //
        // Example XML:
        //
        // <bean id="orderService"
        //       class="org.example.OrderService"/>
        //
        // Then:
        //
        // context.getBean("orderService")
        //
        // returns that particular bean.
//
//        OrderService orderService =
//                (OrderService) context.getBean("orderService");
//
//        orderService.orderPlaced();


        // This approach is useful when multiple beans have the
        // same type because we can specifically tell Spring
        // which bean we want by its id.
        //
        // For example:
        //
        // <bean id="cardPaymentService"
        //       class="org.example.payment.CardPaymentService"/>
        //
        // <bean id="upiPaymentService"
        //       class="org.example.payment.UPIPaymentService"/>
        //
        // Both are PaymentService types, but their ids are different.


        // =========================================================
        // 3. GET BEAN BY ID + TYPE
        // =========================================================

        // We can provide BOTH:
        //
        // 1. Bean id/name
        // 2. Expected class/type
        //
        // This avoids the explicit type cast used in the previous
        // approach.
//
//        OrderService orderService =
//                context.getBean("orderService", OrderService.class);
//
//        PaymentService paymentService =
//                context.getBean("paymentService", PaymentService.class);


        // This is a clean and type-safe way to retrieve a specific
        // bean when we know its id and expected type.
//
//        orderService.orderPlaced();


        // =========================================================
        // 4. GET UserService BEAN
        // =========================================================

        // Here we retrieve the UserService bean using BOTH
        // its XML id and its Java type.
        //
        // "userService" must match the id defined in AppConfig.xml.
        UserService user =
                context.getBean("userService", UserService.class);


        // If UserService had a getUserNames() method, we could
        // retrieve the injected list like this:
//
//        System.out.println(user.getUserNames());


        // =========================================================
        // 5. CLOSE THE SPRING CONTAINER
        // =========================================================

        // Closing the context tells Spring that the application
        // context is shutting down.
        //
        // During shutdown, Spring performs the destruction
        // phase for beans whose destruction it manages.
        //
        // For your UserService, if AppConfig.xml contains:
        //
        // destroy-method="cleanUp"
        //
        // Spring will call:
        //
        // user.cleanUp();
        //
        // before destroying the singleton bean.
        //
        // IMPORTANT:
        // For prototype-scoped beans, Spring creates and provides
        // the objects but does NOT manage their destruction.
        // Therefore, Spring will not call the configured
        // destroy method for prototype beans.
        context.close();
    }
}