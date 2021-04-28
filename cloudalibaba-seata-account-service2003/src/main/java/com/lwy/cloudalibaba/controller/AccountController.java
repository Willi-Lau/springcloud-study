package com.lwy.cloudalibaba.controller;

import com.lwy.cloudalibaba.entity.CommonResult;
import com.lwy.cloudalibaba.entity.Order;
import com.lwy.cloudalibaba.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class AccountController {

    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @PostMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money){

        accountService.decrease(userId, money);

        return new CommonResult(200,"扣减账户余额成功！");
    }
    @PostMapping(value = "/account/tfeign")
    void tfeign(@RequestBody Order order){

        System.out.println(order.getUserId());
    };
}
