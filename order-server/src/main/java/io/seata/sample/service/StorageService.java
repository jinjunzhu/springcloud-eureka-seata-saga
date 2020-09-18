package io.seata.sample.service;

public interface StorageService {

    boolean decrease(String businessKey, Long productId, Integer count);

    /**
     * 补偿扣减库存
     * @param businessKey businessKey
     * @param productId productId
     * @param count count
     * @return
     */
    boolean compensateDecrease(String businessKey, Long productId, Integer count);
}
