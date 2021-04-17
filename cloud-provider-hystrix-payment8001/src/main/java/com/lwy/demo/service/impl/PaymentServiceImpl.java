package com.lwy.demo.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lwy.demo.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return Thread.currentThread().getName()+"id是"+id+"success + from OK";
    }

    /**
     * @param id
     * @return
     * fallbackMethod 出事后产生异常后调用得兜底方法
     * commandProperties 具体的值
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandle",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")  //设置超时时间 超时调用错误得方法
    })
    public String paymentInfo_TimeOut(Integer id) {
        Integer timeNum = 3;
        try{
             TimeUnit.SECONDS.sleep(timeNum);
        }catch(Exception e ){e.printStackTrace();}
        return Thread.currentThread().getName()+"id是"+id+"success from Timeout"+"耗时"+timeNum+"秒";
    }
    @Override
    public String paymentInfo_TimeOutHandle(Integer id) {
        return "paymentInfo_TimeOutHandle false 异常方法";
    }


    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {    //fallbackMethod 报错 返回的方法
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }


    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
