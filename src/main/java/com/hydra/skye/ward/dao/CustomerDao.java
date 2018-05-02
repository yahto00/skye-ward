package com.hydra.skye.ward.dao;

import com.hydra.skye.ward.model.Customer;
import org.springframework.stereotype.Repository;

/**
 * Created by yahto on 28/04/2018 12:24 PM
 */
@Repository
public interface CustomerDao {

    int insertSelective(Customer customer);
}
