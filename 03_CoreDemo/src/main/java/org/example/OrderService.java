package org.example;

import org.example.notification.EmailService;
import org.example.notification.NotificationService;
import org.example.notification.PopUpNotificationService;
import org.example.notification.SmsService;

public class OrderService {

    //but still it is breaking the design principle
    //object creation is not the problem, but where objects are being created is the problem
    //In this class OrderService there should be methods which only belongs to that class
    NotificationService notification; //concrete class OrderService is dependent on this

    public OrderService(NotificationService notification){
        this.notification = notification;   //construction- DI
    }
    public void placeOrder(){
        System.out.println("Order Placed");
        //actual business logic
        notification.sendNotification();
    }

    public OrderService(){

    }

    //DI via setter method
    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }
}
