package com.lwy.demo;

import com.lwy.demo.entity.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient       //zookeeper 服务i其
public class PayMent8004 {
    public static void main(String[] args) {
        SpringApplication.run(PayMent8004.class,args);
    }
}
