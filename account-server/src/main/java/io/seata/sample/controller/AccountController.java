package io.seata.sample.controller;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.sample.service.AccountService;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author jinjunzhu
 */
@RestController
@RequestMapping("account")
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private AccountService accountServiceImpl;

    @RequestMapping("decrease")
    public boolean decrease(@RequestParam("businessKey") String businessKey, @RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        logger.info("businessKey:{}", businessKey);
        return accountServiceImpl.decrease(userId,money);
    }

    @RequestMapping("compensateDecrease")
    public boolean compensateDecrease(@RequestParam("businessKey") String businessKey, @RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        logger.info("businessKey:{}", businessKey);
        return accountServiceImpl.compensateDecrease(userId, money);
    }
}
