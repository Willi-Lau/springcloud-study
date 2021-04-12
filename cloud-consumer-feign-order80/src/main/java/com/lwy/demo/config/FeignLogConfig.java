package com.lwy.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLogConfig {
    /**
     * 设置 日志级别为 FULL
     *  日志级别：
     *             NONE:默认。不显示任何日志
     *             BASIC:记录请求方法，URL,响应状态码及执行时间
     *             HEADERS:BASIC + 请求响应头信息
     *             FULL:HEADERS + 请求响应正文 + 元数据
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
