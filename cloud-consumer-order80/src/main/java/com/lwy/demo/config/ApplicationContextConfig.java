package com.lwy.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
    @LoadBalanced   //默认负载均衡机制  如果想用自己的 就把这个注解去掉
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };

}
