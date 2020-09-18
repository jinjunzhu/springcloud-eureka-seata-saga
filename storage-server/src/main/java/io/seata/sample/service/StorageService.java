package io.seata.sample.service;

/**
 * @author jinjunzhu
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    boolean decrease(Long productId, Integer count);

    /**
     * 回滚扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    boolean compensateDecrease(Long productId, Integer count);
}
