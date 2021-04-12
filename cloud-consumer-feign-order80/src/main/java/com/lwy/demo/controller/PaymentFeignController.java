package com.lwy.demo.controller;

import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import com.lwy.demo.service.PaymentFeignService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentFeignController {
    @Autowired
    private PaymentFeignService service;

    //测试通过Id获取信息
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
            return service.getPaymentById(id);
    }

    //测试 Feign超时
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String FeignTimeOut(){
        //Feign客户端默认等待一秒钟 这里让8001 端 等待三秒钟再返回信息
        return service.FeignTimeOut();
    }
}
