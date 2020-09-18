package io.seata.sample.feign;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author jinjunzhu
 */
@FeignClient(value = "storage-server")
public interface StorageApi {

    /**
     * 扣减库存
     * @param businessKey businessKey
     * @param productId productId
     * @param count count
     * @returns
     */
    @GetMapping(value = "/storage/decrease")
    boolean decrease(@RequestParam("businessKey") String businessKey, @RequestParam("productId") Long productId, @RequestParam("count") Integer count);

    /**
     * 补偿扣减库存
     * @param businessKey businessKey
     * @param productId productId
     * @param count count
     * @return
     */
    @GetMapping(value = "/storage/compensateDecrease")
    boolean compensateDecrease(@RequestParam("businessKey") String businessKey, @RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
