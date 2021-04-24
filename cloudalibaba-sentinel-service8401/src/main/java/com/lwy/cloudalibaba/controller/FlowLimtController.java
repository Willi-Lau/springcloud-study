package com.lwy.cloudalibaba.controller;




import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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











}
