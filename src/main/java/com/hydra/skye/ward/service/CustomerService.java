package com.hydra.skye.ward.service;

import com.hydra.skye.ward.model.Customer;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.CustomerCondition;

import java.util.List;

/**
 * Created by yahto on 28/04/2018 12:34 PM
 */
public interface CustomerService {
    boolean createCustomer(Customer customer);

    List<Customer> queryCustomerByCondition(CustomerCondition customerCondition, PageBean pageBean);
}
