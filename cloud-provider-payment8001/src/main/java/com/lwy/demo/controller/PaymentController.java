package com.lwy.demo.controller;


import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import com.lwy.demo.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j //日志
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    //读取本服务的端口号
    @Value("${server.port}")
    private String serverPort;

    //服务发现    注意是cloud包下的  返回服务列表清单
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        //在日志打印结果
        log.info("*********新增结果"+result);
        if(result >0)
        {
            return new CommonResult(200,"新增数据库成功,port"+serverPort+"   ",result);
        }
        else
        {
            return new CommonResult(404,"新增失败1",null);
        }

    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        //日志打印结果
        log.info("*********查询结果"+payment);
        if(payment != null)
        {
            return new CommonResult(200,"查询成功，port"+serverPort+"   ",payment);
        }
        else
        {
            return new CommonResult(404,"查询失败",null);
        }

    }

    /**
     * 这里是返回所有的服务列表清单
     * @return
     * {
     *     "code": 200,
     *     "message": "返回成功",
     *     "data": [
     *         "cloud-payment-service",
     *         "cloud-consumer-order80"
     *     ]
     * }
     */
    @GetMapping(value = "/payment/getdiscovery")
    public Object discover(){

        List<String> list = discoveryClient.getServices();
        list.forEach((i)->{
            System.out.println("***************"+i);
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");//这里写的是服务器的名字

        instances.forEach((i)->{
            log.info(i.getServiceId()+"\t"+i.getHost()+"\t"+i.getPort()+"\t"+i.getUri());
            //  CLOUD-PAYMENT-SERVICE	192.168.153.1	8002	http://192.168.153.1:8002
        });

        return new CommonResult<>(200,"返回成功",this.discoveryClient);


    }
    /**
     * 返回端口号，测试负载均衡算法的实现
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    /**
     * 测试 Feign 超时
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String FeignTimeOut() throws InterruptedException {
        try{
            TimeUnit.SECONDS.sleep(2);
        }
        finally {

        }
        return "端口号是       "+serverPort;
    }

 }
