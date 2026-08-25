package org.example;

import org.example.notification.EmailService;
//import org.example.notification.FakeEmailService;
import org.example.notification.NotificationService;
//import org.example.notification.SmsService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //OrderService gets dependency via main
        NotificationService notification = new EmailService();
        //by this we can make our UNIT testing better

        //OrderService order = new OrderService(notification);
        OrderService order = new OrderService();
        order.setNotification(notification);
        order.placeOrder();
    }
}

//A class should ask what it needs, and not build everything itself
//Don't create your own dependency, but get your dependency

//IoC --> Inversion of Control
//DI is the technique to implement IoC
//where classes gets their dependency from outside

//Spring Framework has IoC container which manages all the things that  main now doing
//1. creates Objects
//2. Manages Objects
//3. Connects Object together

//Objects --> Java code
//Spring IoC container --> Bean