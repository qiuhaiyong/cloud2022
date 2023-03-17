package com.qhy.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/nacos/get/{id}")
    public String getServerPort(@PathVariable(value = "id") Integer id){
        return "nacos register, serverPort:" + serverPort + "\t" + "id:" + id;
    }

}
