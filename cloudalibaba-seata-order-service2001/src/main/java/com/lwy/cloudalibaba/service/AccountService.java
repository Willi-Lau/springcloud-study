package com.lwy.cloudalibaba.service;

import com.lwy.cloudalibaba.entity.CommonResult;
import com.lwy.cloudalibaba.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentMap;

/**
 * @auther zzyy
 * @create 2020-02-26 15:22
 */
@Component
@FeignClient(value = "seata-account-service")
public interface AccountService
{
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Integer userId, @RequestParam("money") BigDecimal money);

    @PostMapping(value = "/account/tfeign")
    void tfeign(@RequestBody Order order);
}
