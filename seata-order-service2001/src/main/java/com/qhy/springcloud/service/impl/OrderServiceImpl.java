package com.qhy.springcloud.service.impl;

import com.qhy.springcloud.dao.OrderDao;
import com.qhy.springcloud.domain.Order;
import com.qhy.springcloud.service.AccountService;
import com.qhy.springcloud.service.OrderService;
import com.qhy.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author (oWo)
 * @date 2022/10/27 10:05
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("---------->开始创建新订单");
        orderDao.create(order);

        log.info("---------->订单微服务开始调用库存，做扣减Count");
        storageService.decrease(order.getProductId(), order.getCount());

        log.info("---------->账户余额扣减Money");
        accountService.decrease(order.getUserId(), order.getMoney());

        //修改订单状态 从0到1，1代表完成
        log.info("---------->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("---------->修改订单状态结束");

        log.info("------------>下单结束O(∩_∩)O");
    }
}
