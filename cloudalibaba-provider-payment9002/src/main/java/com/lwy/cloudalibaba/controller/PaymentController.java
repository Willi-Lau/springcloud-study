package com.lwy.cloudalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String server_port;

    @GetMapping("/payment/nacos/{id}")
    public String nacosgetid(@PathVariable(value = "id") Integer id){
        return "nacos port" + server_port + "success"+"  you id is"+id;
    }
}
