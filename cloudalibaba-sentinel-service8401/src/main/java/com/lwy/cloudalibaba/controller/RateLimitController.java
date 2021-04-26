package com.lwy.cloudalibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lwy.demo.entity.CommonResult;
import com.lwy.demo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.crypto.Commitment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lwy.cloudalibaba.myHandle.CustomerBlockHandler;

@RestController
@Slf4j
public class RateLimitController {

    @GetMapping(value = "/byResource")
    @SentinelResource(value = "byResource",blockHandler = "deal_byResource")
    public CommonResult byResource(){
            return new CommonResult(200,"按照资源名限流ok",new Payment(2020L,"seerial001"));
    }

    /**
     * 兜底方法
     */
    public CommonResult deal_byResource(BlockException e){
        return new CommonResult(444,e.getClass().getCanonicalName()+"服务不可用");
    }


    @GetMapping("/rateLimit/byUrl")      //这里没有 blockHandler 就用系统自带的兜底方法
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }

    /**
     * 全局统一处理 异常
     * @return
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,        //流控异常处理类
            blockHandler = "handlerException2")              //流控异常处理方法
    public CommonResult customerBlockHandler()
    {
        return new CommonResult(200,"按客戶自定义",new Payment(2020L,"serial003"));
    }


}
