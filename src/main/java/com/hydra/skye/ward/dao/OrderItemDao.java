package com.hydra.skye.ward.dao;

import com.hydra.skye.ward.model.OrderItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yahto on 2018/5/6 7:23 PM
 */
@Repository
public interface OrderItemDao {
    int insertBatch(@Param("list") List<OrderItem> orderItemList);
}
