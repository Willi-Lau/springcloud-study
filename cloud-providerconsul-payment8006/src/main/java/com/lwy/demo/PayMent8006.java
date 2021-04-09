package com.lwy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient       //zookeeper 服务i其
public class PayMent8006 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent8006.class,args);
    }
}
