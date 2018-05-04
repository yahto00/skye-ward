package com.hydra.skye.ward.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.hydra.skye.ward.dao.CustomerDao;
import com.hydra.skye.ward.model.Customer;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.CustomerCondition;
import com.hydra.skye.ward.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Customer> queryCustomerByCondition(CustomerCondition customerCondition, PageBean pageBean) {
        Integer limitY = pageBean.getPageSize();
        Page<Customer> result = PageHelper.startPage(pageBean.getPageIndex(), limitY);
        List<Customer> voList = customerDao.queryCustomerByCondition(customerCondition);
        pageBean.setCounts(result.getTotal());
        return voList == null ? Lists.newArrayList() : voList;
    }
}
