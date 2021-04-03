package com.lwy.demo.controller;


import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import com.lwy.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@Slf4j //日志
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        //在日志打印结果
        log.info("*********插入结果"+result);


        if(result >0)
        {
            return new CommonResult(200,"插入数据库成功",result);
        }
        else
        {
            return new CommonResult(404,"插入失败",null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        //日志打印结果
        log.info("*********插入结果"+payment);
        if(payment != null)
        {
            return new CommonResult(200,"查询成功",payment);
        }
        else
        {
            return new CommonResult(404,"查询失败",null);
        }

    }


}
