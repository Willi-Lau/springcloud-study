package com.lwy.cloudalibaba.controller;




import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class FlowLimtController {
    @GetMapping(value = "/sentinel/testA")
    public String testA(){
        return "TestA";
    }

    @GetMapping(value = "/sentinel/testB")
    public String testB(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "Testb";
    }




    @GetMapping(value = "/sentinel/testD")
    public String testD(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        log.info("this is Test D");
        return "Testd";
    }

    /**
     * sentinel blockHandler 只能对sentinel里设置的异常进行处理 如果有 运行时异常 blockhandle 不会进行处理
     * @param p1
     * @param p2
     * @return
     */

    @GetMapping(value = "/sentinel/testHotPoint")
    @SentinelResource(value = "testHotPoint",blockHandler = "deal_testHotPoint")   //blockHandler 配置兜底方法
    public String testHotPoint(                                   // value 名字 sentinel配置热点监控 资源名就写的是value
            @RequestParam(value = "p1",required = false) String p1,     //参数列表中 p1 是下标为0的参数
            @RequestParam(value = "p2",required = false) String p2      //参数列表中 p2 是下标为1的参数
    ){
        return "this is success hotpoint";
    }

    public String deal_testHotPoint(String p1,String p2,BlockException e){  //兜底方法 后面比原来的参数列表多BlockException
        return "this is wrong hotpoint";
    }












}
