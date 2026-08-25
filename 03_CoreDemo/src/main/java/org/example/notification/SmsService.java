package org.example.notification;

public class SmsService implements NotificationService{

    @Override
    public void sendNotification(){
        System.out.println("Sms notification sent");
    }
}
