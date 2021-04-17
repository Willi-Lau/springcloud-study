package com.lwy.demo.service;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.PathVariable;

public interface PaymentService {
    /**
     * 一定OK得方法
     */
     String paymentInfo_OK(Integer id);
    /**
     * 超时得方法
     */
     String paymentInfo_TimeOut(Integer id);

    /**
     * 超时得方法 得兜底方法
     */
    String paymentInfo_TimeOutHandle(Integer id);
    /**
     * 服务熔断
     */
     String paymentCircuitBreaker(Integer id);
    /**
     * 熔断 返回的 方法
     * @param id
     * @return
     */
     String paymentCircuitBreaker_fallback(Integer id);

}
