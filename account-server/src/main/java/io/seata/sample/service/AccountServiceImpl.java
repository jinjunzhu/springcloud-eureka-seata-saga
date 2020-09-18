package io.seata.sample.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.seata.sample.dao.AccountDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author jinjunzhu
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService{

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountDao accountDao;

    @Override
    public boolean decrease(Long userId, BigDecimal payAmount) {
        LOGGER.info("------->尝试扣减账户开始account, userId:{}, payAmount:{}", userId, payAmount);
        accountDao.decrease(userId, payAmount);
        LOGGER.info("------->尝试扣减账户结束account");

        return true;

    }

    @Override
    public boolean compensateDecrease(Long userId, BigDecimal payAmount){
        LOGGER.info("------->尝试补偿扣减账户开始account, userId:{}, payAmount:{}", userId, payAmount);
        accountDao.decrease(userId, payAmount.negate());
        LOGGER.info("------->尝试补偿扣减账户结束account");
        return true;
    }

}
