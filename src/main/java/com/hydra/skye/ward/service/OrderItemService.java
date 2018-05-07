package com.hydra.skye.ward.service;

import com.hydra.skye.ward.model.OrderItem;

import java.util.List;

/**
 * Created by yahto on 2018/5/6 7:35 PM
 */
public interface OrderItemService {
    boolean insertBatch(List<OrderItem> orderItemList);
}
