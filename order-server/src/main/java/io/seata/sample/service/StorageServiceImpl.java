package io.seata.sample.service;

import io.seata.sample.feign.StorageApi;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service("storageService")
public class StorageServiceImpl implements StorageService{

    @Resource
    private StorageApi storageApi;

    @Override
    public boolean decrease(String businessKey, Long productId, Integer count) {
        return storageApi.decrease(businessKey, productId, count);
    }

    @Override
    public boolean compensateDecrease(String businessKey, Long productId, Integer count) {
        return storageApi.compensateDecrease(businessKey, productId, count);
    }
}
