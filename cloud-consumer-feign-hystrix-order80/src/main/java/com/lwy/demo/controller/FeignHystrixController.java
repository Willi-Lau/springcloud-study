package com.lwy.demo.controller;


import com.lwy.demo.FeignHystrixOrder80;
import com.lwy.demo.service.FeignHystrixService;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignHystrixController {

    @Autowired
    private FeignHystrixService service;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id")Integer id){
           return service.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandle" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")   //设置最大超时时间
    })
    String paymentInfo_TimeOut(@PathVariable("id")Integer id){
           return service.paymentInfo_TimeOut(id);
    }


    String paymentInfo_TimeOutHandle(@PathVariable("id")Integer id){
        return "这里是 FeignHystrixOrder80 现在超时了";
    }
}
