package com.hydra.skye.ward.service.impl;

import com.hydra.skye.ward.dao.OrderItemDao;
import com.hydra.skye.ward.model.OrderItem;
import com.hydra.skye.ward.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yahto on 2018/5/6 7:36 PM
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    public boolean insertBatch(List<OrderItem> orderItemList) {
        return orderItemDao.insertBatch(orderItemList) == orderItemList.size() ? true : false;
    }
}
