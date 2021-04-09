package com.lwy.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PayMentController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * 通过 zookeeper 80 控制端来调用 这个方法 打印端口号
     * @return
     */
    @RequestMapping(value = "/payment/consul")
    public String paymentzk()
    {
        return "springcloud with consul: "+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
