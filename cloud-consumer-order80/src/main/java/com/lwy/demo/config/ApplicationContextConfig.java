package com.lwy.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig
{
    /**
     * 依赖注入 RestTemplate 用于Http通信
     * @return
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };

}
