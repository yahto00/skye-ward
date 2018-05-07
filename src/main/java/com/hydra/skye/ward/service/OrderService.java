package com.hydra.skye.ward.service;

import com.hydra.skye.ward.model.Order;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.OrderQueryCondition;
import com.hydra.skye.ward.model.dto.OrderItemDto;
import com.hydra.skye.ward.model.vo.OrderVo;

import java.util.List;

/**
 * Created by yahto on 2018/5/6 7:34 PM
 */
public interface OrderService {
    void createOrder(Order order, List<OrderItemDto> orderItemDtoList);

    List<OrderVo> queryOrderByCondition(OrderQueryCondition condition, PageBean pageBean);
}
