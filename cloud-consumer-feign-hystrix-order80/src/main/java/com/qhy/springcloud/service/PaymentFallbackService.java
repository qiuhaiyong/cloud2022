package com.qhy.springcloud.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "PaymentFallbackService fallback-paymentInfo_ok,┭┮﹏┭┮";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService fallback-paymentInfo_TimeOut,┭┮﹏┭┮";
    }

}
