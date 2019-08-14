package com.wyy.order.service.impl;

import com.wyy.order.dataobject.OrderMaster;
import com.wyy.order.dto.OrderDTO;
import com.wyy.order.enums.OrderStatusEnum;
import com.wyy.order.enums.PayStatusEnum;
import com.wyy.order.repository.OrderDetailRepository;
import com.wyy.order.repository.OrderMasterRepository;
import com.wyy.order.service.OrderService;
import com.wyy.order.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单服务
 *
 * @Author WYY
 * @Date 2019-08-13 15:31
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        //TODO 1.调用商品服务
        //TODO 2.计算总价
        //TODO 3.扣库存
        //订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.generateUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
