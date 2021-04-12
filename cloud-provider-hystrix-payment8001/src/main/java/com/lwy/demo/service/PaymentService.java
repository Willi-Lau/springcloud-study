package com.lwy.demo.service;

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
}
