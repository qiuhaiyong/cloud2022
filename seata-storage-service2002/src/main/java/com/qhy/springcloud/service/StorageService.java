package com.qhy.springcloud.service;

/**
 * @author (oWo)
 * @date 2022/10/27 10:48
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}
