package com.lwy.cloudalibaba.myHandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import com.lwy.demo.entity.CommonResult;

/**
  * 自定义限流处理类 只会再sentinel 处理的异常 -时才会调用
 */
public class CustomerBlockHandler
{
    public static CommonResult handlerException(BlockException exception)
    {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }
    public static CommonResult handlerException2(BlockException exception)
    {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}
