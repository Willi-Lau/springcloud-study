package com.lwy.cloudalibaba.controller;

import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverport;

    public static HashMap<Integer, Payment> map = new HashMap();
    static{
        map.put(1,new Payment(1,"p1111111111"));
        map.put(2,new Payment(2,"p2222222222"));
        map.put(3,new Payment(3,"p33333333333"));
    }

    @GetMapping(value = "/getPayment/{id}")
    public CommonResult<Payment> getPaymentByID(@PathVariable("id") Integer id){
        Payment payment = map.get(id);
        return new CommonResult<>(200,"port"+serverport,payment);
    }
}
