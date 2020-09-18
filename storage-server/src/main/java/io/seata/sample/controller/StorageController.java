package io.seata.sample.controller;

import io.seata.sample.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author jinjunzhu
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     * @param businessKey businessKey
     * @param productId 产品id
     * @param count 数量
     * @return 扣减库存结果
     */
    @RequestMapping("decrease")
    public boolean decrease(@RequestParam("businessKey") String businessKey, @RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        logger.info("businessKey:{}", businessKey);
        return storageService.decrease(productId, count);
    }

    /**
     * 补偿扣减库存
     * @param businessKey businessKey
     * @param productId 产品id
     * @param count 数量
     * @return 补偿结果
     */
    @RequestMapping("compensateDecrease")
    public boolean compensateDecrease(@RequestParam("businessKey") String businessKey, @RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        logger.info("businessKey:{}", businessKey);
        return storageService.compensateDecrease(productId, count);
    }
}
