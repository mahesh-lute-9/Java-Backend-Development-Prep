package com.example.profileDemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"dev","default","staging"})
// we can give diff environments in this at once as if we don't give it gives error as implementation for the NotificationService for --- this environment does not exist so
// if we want to vary configuration then we do profiling
// if we want to vary bean then we use @Profile anf then we pass it the environment that we want
public class DummyNotificationServiceImpl implements NotificationService{

    @Override
    public String send() {

        // dummy notification - no real notification is sent

        return "Here is a dummy notification";
    }
}
