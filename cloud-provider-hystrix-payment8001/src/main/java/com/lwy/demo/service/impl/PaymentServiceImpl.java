package com.lwy.demo.service.impl;

import com.lwy.demo.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return Thread.currentThread().getName()+"id是"+id+"success + from OK";
    }

    /**
     *
     * @param id
     * @return
     * fallbackMethod 出事后产生异常后调用得兜底方法
     * commandProperties 具体的值
     *
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

//        int i = 1/0;
//        return Thread.currentThread().getName()+"id是"+id+"success from Timeout";
    }

    @Override
    public String paymentInfo_TimeOutHandle(Integer id) {
        return "paymentInfo_TimeOutHandle false 异常方法";
    }


}
