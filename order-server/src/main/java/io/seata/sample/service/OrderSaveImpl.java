package io.seata.sample.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.sample.dao.OrderDao;
import io.seata.sample.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("orderSave")
public class OrderSaveImpl implements OrderApi{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private OrderDao orderDao;

    @Override
    public boolean saveOrder(String businessKey, Order order) {
        logger.info("保存订单, businessKey：{}, order: {}", businessKey, order);
        orderDao.create(order);
        return true;
    }

    /**
     * 回滚事务,删除订单
     * @param order order
     * @return
     */
    @Override
    public boolean deleteOrder(String businessKey,Order order){
        logger.info("删除订单, businessKey：{}, order: {}", businessKey, order);
        orderDao.delete(order);
        return true;
    }
}
