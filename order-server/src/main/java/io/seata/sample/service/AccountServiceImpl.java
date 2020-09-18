package io.seata.sample.service;

import io.seata.sample.feign.AccountApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Resource
    private AccountApi accountApi;

    @Override
    public boolean decrease(String businessKey, Long userId, BigDecimal money) {
        return accountApi.decrease(businessKey, userId, money);
    }

    @Override
    public boolean compensateDecrease(String businessKey, Long userId, BigDecimal money) {
        return accountApi.compensateDecrease(businessKey, userId, money);
    }
}
