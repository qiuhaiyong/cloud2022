package com.qhy.springcloud.service;

import com.qhy.springcloud.entities.CommonResult;
import com.qhy.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author (oWo)
 * @date 2022/10/26 17:00
 */
@Component
public class PaymentFallBackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"error serial"));
    }
}
