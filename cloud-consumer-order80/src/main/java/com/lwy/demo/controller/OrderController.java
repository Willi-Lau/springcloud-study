package com.lwy.demo.controller;

import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@Slf4j
public class OrderController
{
    //通信地址 单机
    //public static final String PAYMENT_URL = "http://localhost:8001";
    //通信地址 负载均衡 写application.yml里配置的spring application name 项目名字
    //这样会随机访问 项目名为CLOUD-PAYMENT-SERVICE 的所有端口 8001 8002.。。
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    //新增
    @GetMapping(value = "/consumer/payment/create")
    public CommonResult create(Payment payment){
        //执行 post  参数为url 传递参数 返回值类型
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    //查询
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        //执行 get  参数为 url(加参数) 返回类型
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

}
