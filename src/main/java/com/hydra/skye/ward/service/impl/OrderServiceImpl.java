package com.hydra.skye.ward.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.hydra.skye.ward.common.exception.BusinessException;
import com.hydra.skye.ward.dao.OrderDao;
import com.hydra.skye.ward.model.Order;
import com.hydra.skye.ward.model.OrderItem;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.OrderQueryCondition;
import com.hydra.skye.ward.model.dto.OrderItemDto;
import com.hydra.skye.ward.model.vo.OrderVo;
import com.hydra.skye.ward.service.CargoService;
import com.hydra.skye.ward.service.OrderItemService;
import com.hydra.skye.ward.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by yahto on 2018/5/6 7:35 PM
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private CargoService cargoService;

    @Transactional
    @Override
    public void createOrder(Order order, List<OrderItemDto> orderItemDtoList) {
        int res1 = orderDao.insertSelective(order);
        if (res1 <= 0) {
            throw new BusinessException("创建订单失败,请重试!");
        }
        List<OrderItem> orderItemList = Lists.newArrayList();
        for (OrderItemDto dto : orderItemDtoList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setCargoId(dto.getCargoId());
            orderItem.setCreateAt(new Date());
            orderItem.setItemArea(dto.getItemArea());
            orderItem.setItemCount(dto.getItemCount());
            orderItem.setOrderId(order.getId());
            if (!cargoService.createOrder(dto)) {
                throw new BusinessException("订单货物参数错误,请检查!");
            }
        }
        if (!orderItemService.insertBatch(orderItemList)) {
            throw new BusinessException("订单货物创建失,请重试!");
        }
    }

    @Override
    public List<OrderVo> queryOrderByCondition(OrderQueryCondition condition, PageBean pageBean) {
        Integer limitY = pageBean.getPageSize();
        Page<OrderVo> result = PageHelper.startPage(pageBean.getPageIndex(), limitY);
        List<OrderVo> voList = orderDao.queryOrderByCondition(condition);
        pageBean.setCounts(result.getTotal());
        return voList == null ? Lists.newArrayList() : voList;
    }
}
