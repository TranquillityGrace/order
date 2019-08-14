package com.wyy.order.controller;

import com.wyy.order.config.ProductClient;
import com.wyy.order.dataobject.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用间通信---Feign
 *
 * @Author WYY
 * @Date 2019-08-14 15:47
 */
@RestController
@Slf4j
public class ClientController2 {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        String response = productClient.productMsg();
        log.info("response=" + response);
        return response;
    }


    @PostMapping("/getProductList")
    public List<ProductInfo> getProductList(){
        List<String> list = new ArrayList<>();
        list.add("157875227953464068");
        list.add("164103465734242707");
        List<ProductInfo> response = productClient.getProductInfo(list);
        log.info("商品列表=" + response);
        return response;
    }
}
