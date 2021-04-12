package com.lwy.myrule.config;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    /**
     * 自定义负载均衡算法 不采用轮询采用随机
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
