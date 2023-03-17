package com.qhy.springcloud.service;

import com.qhy.springcloud.entities.CommonResult;
import com.qhy.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author (oWo)
 * @date 2022/10/26 16:53
 */
@FeignClient(value = "nacos-payment-provider" ,fallback = PaymentFallBackService.class)
public interface PaymentService {

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);

}
