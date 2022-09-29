package com.qhy.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qhy.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        String result = paymentHystrixService.paymentInfo_ok(id);
        return result;
    }


    @GetMapping("/consumer/payment/hystrix/timeOut/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutFallback",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id){
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }


    public String paymentInfoTimeOutFallback(@PathVariable("id")Integer id){
        return "消费者80端，对方支付系统出错，或者检查自身错误" + id;
    }

    //全局fallback
    public String globalFallback(){
        return "GLOBAL异常处理信息~~~稍后再试";
    }
}
