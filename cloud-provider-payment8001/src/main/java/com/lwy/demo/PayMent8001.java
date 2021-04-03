package com.lwy.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@MapperScan("com.lwy.demo.dao")
@SpringBootApplication
public class PayMent8001
{
    public static void main(String[] args) {
        SpringApplication.run(PayMent8001.class,args);
    }
}
