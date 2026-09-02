package org.example.payment;

import org.springframework.stereotype.Component;
//adding interface for loose coupling
public interface PaymentService {

    void pay();
}