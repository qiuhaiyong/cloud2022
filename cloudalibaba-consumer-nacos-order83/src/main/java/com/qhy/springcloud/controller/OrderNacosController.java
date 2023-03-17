package com.qhy.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class OrderNacosController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String  serverUrl;

    @RequestMapping("/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Integer id){
        return  restTemplate.getForObject(serverUrl + "/payment/nacos/get/" + id ,String.class);
    }


}
