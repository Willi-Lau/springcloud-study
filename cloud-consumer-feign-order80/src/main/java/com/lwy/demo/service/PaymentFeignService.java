package com.lwy.demo.service;

import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")      //绑定微服务名称 选择调用哪一个微服务
public interface PaymentFeignService {
    //针对CLOUD-PAYMENT-SERVICE 微服务 8081 8082 的业务进行书写
     @GetMapping(value = "/payment/get/{id}")        //绑定要具体调用的方法
     CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);        //这里得按照 GetMappming 接受写

    //测试 Feign超时
    @GetMapping(value = "/payment/feign/timeout")
    public String FeignTimeOut();
}
