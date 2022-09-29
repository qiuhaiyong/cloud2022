package com.qhy.springcloud.controller;

import com.qhy.springcloud.entities.CommonResult;
import com.qhy.springcloud.entities.Payment;
import com.qhy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("插入结果***：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPort, payment);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public CommonResult getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果*******：:" + payment);

        if (payment != null) {
            return new CommonResult(200, "查询成功serverPort:" + serverPort, payment);
        }else {
            return new CommonResult(444,"查询失败",null);
        }
    }

    @GetMapping("lb")
    public String getPaymentLB() {
        return serverPort;
    }


}
