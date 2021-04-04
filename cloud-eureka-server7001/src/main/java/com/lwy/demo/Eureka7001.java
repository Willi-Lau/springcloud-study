package com.lwy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer    //开启Eureka服务注册中心
public class Eureka7001 {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7001.class,args);
    }
}
