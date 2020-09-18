package io.seata.sample.service;

import io.seata.sample.dao.StorageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * @author jinjunzhu
 */
@Service("storageService")
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    @Override
    public boolean decrease(Long productId, Integer count) {
        LOGGER.info("扣减库存, commit, productId:{}, count:{}", productId, count);
        storageDao.decrease(productId, count);
        throw new RuntimeException();
    }

    @Override
    public boolean compensateDecrease(Long productId, Integer count) {
        LOGGER.info("补偿扣减库存, compensate, productId:{}, count:{}", productId, count);
        storageDao.compensateDecrease(productId, count);
        return true;
    }
}
