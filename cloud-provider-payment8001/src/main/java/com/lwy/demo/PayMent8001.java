package com.lwy.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//@MapperScan("com.lwy.demo.dao")
@SpringBootApplication
@EnableEurekaClient
public class PayMent8001
{
    public static void main(String[] args) {
        SpringApplication.run(PayMent8001.class,args);
    }
}
