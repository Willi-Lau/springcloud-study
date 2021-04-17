package com.lwy.demo.service;

import org.springframework.stereotype.Component;

/**
 * 这个类是实现客户端通过Feign往服务端发送信息时，服务端突然宕机，关机，通过Hystrix 进行
 * 全局处理时，为Feign 接口得每一个方法都定义了一个 发生异常时得值
 */
@Component
public class FeignFallBackService implements FeignHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return " paymentInfo_OK 80 false";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return " paymentInfo_TimeOut 80 false";
    }
}
