package com.wyy.order.controller;

import com.wyy.order.converter.OrderForm2OrderDTO;
import com.wyy.order.dto.OrderDTO;
import com.wyy.order.enums.ResultEnum;
import com.wyy.order.exception.OrderException;
import com.wyy.order.form.OrderForm;
import com.wyy.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单控制层
 *
 * @Author WYY
 * @Date 2019-08-13 15:26
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Map<String,String> createOrder(@Valid OrderForm orderForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            log.error("创建订单form=[{}]参数不正确",orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        //orderForm --> orderDto
        OrderDTO orderDto = OrderForm2OrderDTO.convert(orderForm);
//        if(CollectionUtils.isEmpty(orderDto.getOrderDetailList())){
//            log.error("购物车为空");
//            throw new OrderException(ResultEnum.CART_EMPTY);
//        }

        orderDto = orderService.create(orderDto);
        Map<String,String> map = new HashMap<>();
        map.put("orderId", orderDto.getOrderId());
        return map;
    }

}
