package com.lwy.cloudalibaba.service;

import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallback.class)
public interface PaymentService {
    @GetMapping(value = "/getPayment/{id}")
    public CommonResult<Payment> getPaymentByID(@PathVariable("id") Integer id);
}
