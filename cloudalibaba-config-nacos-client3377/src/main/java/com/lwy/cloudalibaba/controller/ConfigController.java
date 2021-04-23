package com.lwy.cloudalibaba.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //支持Nacos的动态刷新功能。
public class ConfigController {

    @Value("${config.info}")     //注意这里读取的是 nacos yaml 配置文件里的信息
    private String configinfo;

    @GetMapping("/nacos/getconfiginfo")
    public String getConfiginfo(){
        return configinfo;
    }
}
