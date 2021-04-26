package com.lwy.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lwy.cloudalibaba.service.PaymentService;
import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@Slf4j
public class CircleBreakerController {

    @Autowired
    private RestTemplate restTemplate;

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private PaymentService service;


    @RequestMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",
                     fallback = "handlerFallback",
                     blockHandler = "blockHandler")            //fallback 负责程序运行时的异常
    public CommonResult<Payment>fallback(@PathVariable("id") Integer id){

        //CommonResult result = restTemplate.getForObject(SERVICE_URL + "/getPayment/" + id, CommonResult.class);
        CommonResult result = service.getPaymentByID(id);

        if(result.getData() == null){
           throw new NullPointerException("无对应的值");
        }
        if(id == 4 ){
            throw new IllegalArgumentException ("IllegalArgumentException,非法参数异常....");
        }

        return result;

    }

    //本例是fallback  管理java 运行时的异常
    public CommonResult handlerFallback(@PathVariable("id") Integer id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }
    //本例是blockHandler  管理Sentinel里发生的异常
    public CommonResult blockHandler(@PathVariable("id") Integer id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }
}
