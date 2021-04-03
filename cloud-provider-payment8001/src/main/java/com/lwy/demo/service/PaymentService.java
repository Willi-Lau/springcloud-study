package com.lwy.demo.service;

import com.lwy.demo.entity.Payment;

public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(long id);
}
