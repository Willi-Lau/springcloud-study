package com.lwy.cloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient        //服务注册
public class Payment9001 {
    public static void main(String[] args) {
        SpringApplication.run(Payment9001.class,args);
    }
}
