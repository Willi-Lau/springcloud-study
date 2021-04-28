package com.lwy.cloudalibaba.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.lwy.cloudalibaba.dao")
public class MybatisConfig {
}
