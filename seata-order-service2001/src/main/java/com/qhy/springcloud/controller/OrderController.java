package com.qhy.springcloud.controller;

import com.qhy.springcloud.domain.CommonResult;
import com.qhy.springcloud.domain.Order;
import com.qhy.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author (oWo)
 * @date 2022/10/27 10:29
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult<>(200,"订单创建成功");
    }
}
