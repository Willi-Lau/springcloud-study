package com.lwy.cloudalibaba.service;

import com.lwy.cloudalibaba.entity.Order;

import java.util.concurrent.ConcurrentMap;

/**
 * @auther zzyy
 * @create 2020-02-26 15:19
 */
public interface OrderService
{
    void create(Order order);

    void tFeign(Order order);
}
