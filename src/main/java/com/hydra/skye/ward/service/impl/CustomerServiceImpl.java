package com.hydra.skye.ward.service.impl;

import com.hydra.skye.ward.dao.CustomerDao;
import com.hydra.skye.ward.model.Customer;
import com.hydra.skye.ward.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yahto on 28/04/2018 12:35 PM
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean createCustomer(Customer customer) {
        return customerDao.insertSelective(customer) > 0 ? true : false;
    }
}
