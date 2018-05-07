package com.hydra.skye.ward.dao;

import com.hydra.skye.ward.model.Order;
import com.hydra.skye.ward.model.condition.OrderQueryCondition;
import com.hydra.skye.ward.model.vo.OrderVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yahto on 2018/5/6 7:24 PM
 */
@Repository
public interface OrderDao {
    int insertSelective(Order order);

    List<OrderVo> queryOrderByCondition(@Param("condition") OrderQueryCondition condition);
}
