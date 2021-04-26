package com.lwy.cloudalibaba.service;

import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallback implements PaymentService{
    @Override
    public CommonResult<Payment> getPaymentByID(Integer id) {
        return new CommonResult<>(44444,"Feign服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
