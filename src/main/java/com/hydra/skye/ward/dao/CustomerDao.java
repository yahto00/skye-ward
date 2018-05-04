package com.hydra.skye.ward.dao;

import com.hydra.skye.ward.model.Customer;
import com.hydra.skye.ward.model.condition.CustomerCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yahto on 28/04/2018 12:24 PM
 */
@Repository
public interface CustomerDao {

    int insertSelective(Customer customer);

    List<Customer> queryCustomerByCondition(@Param("condition") CustomerCondition customerCondition);
}
