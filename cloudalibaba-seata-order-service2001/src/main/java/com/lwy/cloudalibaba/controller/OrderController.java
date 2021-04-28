package com.lwy.cloudalibaba.controller;

import com.lwy.cloudalibaba.entity.CommonResult;
import com.lwy.cloudalibaba.entity.Order;
import com.lwy.cloudalibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @auther zzyy
 * @create 2020-02-26 15:24
 */
@RestController
public class OrderController
{
    @Resource
    private OrderService orderService;


    @PostMapping("/order/create")
    public CommonResult create(@RequestBody Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }

    @PostMapping("/testFeign")
    public CommonResult tfeign()
    {
//        ConcurrentMap map = new ConcurrentHashMap();
//        map.put("111",111);
//        map.put("222",222);
        Order order = new Order();
        order.setUserId(11111);
        orderService.tFeign(order);
        return new CommonResult(200,"sucess");
    }


}
