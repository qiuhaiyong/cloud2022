package com.qhy.springcloud.service;

import com.qhy.springcloud.dao.StorageDao;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author (oWo)
 * @date 2022/10/27 10:49
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);
    @Override
    public void decrease(Long productId, Integer count) {
        logger.info("------>storage-service开始扣减库存");
        storageDao.decrease(productId,count);
        logger.info("------>storage-service扣减库存结束");
    }
}
