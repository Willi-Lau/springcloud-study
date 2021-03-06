package com.lwy.demo.controller;


import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import com.lwy.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j //日志
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
     //读取本服务的端口号
    @Value("${server.port}")
    private String serverPort;

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
            return new CommonResult(200,"查询成功,port"+serverPort+"   ",payment);
        }
        else
        {
            return new CommonResult(404,"查询失败",null);
        }

    }
    /**
     * 返回端口号，测试负载均衡算法的实现
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }



}
