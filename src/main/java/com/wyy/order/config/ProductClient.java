package com.wyy.order.config;

import com.wyy.order.dataobject.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 使用feign组件访问product服务
 *
 * @Author WYY
 * @Date 2019-08-14 15:32
 */
@FeignClient(name="product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/getProductListForOrder")
    List<ProductInfo> getProductInfo(List<String> productIdList);
}
