package com.wyy.order.controller;

import com.wyy.order.config.RestTemplateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 微服务之间通信
 * RestTemplate的三种使用方式
 * @Author WYY
 * @Date 2019-08-14 10:32
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getProductMsg1")
    public String getMsg1(){

        //第一种通信方式：restTemplate
        //缺点：不知道对方的Ip;URL硬编码，不利于维护；对方有多个节点提供同一服务
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:9002/msg",String.class);
        log.info("response=" + result);
        return result;
    }

    @GetMapping("/getProductMsg2")
    public String getMsg2(){

        //第二种通信方式：loadBalancerClient
        //通过应用名获取host及port
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");

        String url = String.format("http://%s:%s", serviceInstance.getHost(),
                serviceInstance.getPort()) + "/msg";

        log.info("url=" + url);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        log.info("response=" + result);
        return result;
    }


    @GetMapping("/getProductMsg3")
    public String getMsg3(){

        //第三种通信方式：loadBalanced
        //负载均衡策略：轮询...
        String result = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        log.info("response=" + result);
        return result;
    }
}
