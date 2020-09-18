package io.seata.sample.service;

import java.math.BigDecimal;

public interface AccountService {

    /**
     * 调用账户服务扣减账户余额
     * @param businessKey
     * @param userId 用户id
     * @param money 金额
     * @return
     */
    boolean decrease(String businessKey, Long userId, BigDecimal money);

    /**
     * 交易补偿，调用账户服务把扣减的账户金额加回去.
     *
     * @param businessKey
     * @param userId userId
     * @param money money
     * @return the boolean
     */
    boolean compensateDecrease(String businessKey, Long userId, BigDecimal money);
}
