package com.hydra.skye.ward.web;

import com.hydra.skye.ward.common.enums.DataCode;
import com.hydra.skye.ward.model.Customer;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.CustomerCondition;
import com.hydra.skye.ward.model.result.Result;
import com.hydra.skye.ward.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by yahto on 28/04/2018 12:28 PM
 */
@RequestMapping("/api/customer")
@Controller
@Api(value = "客户管理", description = "客户API")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/createCustomer.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "创建客户信息", notes = "创建客户信息", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "客户名称", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "客户电话", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "email", value = "客户邮箱", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "address", value = "客户地址", dataType = "String", required = true, paramType = "query")
    })
    public Result createCustomer(@RequestParam("name") String name,
                                 @RequestParam("phone") String phone,
                                 @RequestParam("email") String email,
                                 @RequestParam("address") String address) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(name) || StringUtils.isEmpty(address)) {
            return new Result().fail("客户信息未填写完整", DataCode.SERVICEERROR);
        }
        Customer customer = new Customer();
        customer.setAddress(address);
        customer.setEmail(email);
        customer.setName(name);
        customer.setPhone(phone);
        customer.setCreateAt(new Date());
        customer.setUpdateAt(new Date());
        if (!customerService.createCustomer(customer)) {
            return new Result().fail("创建客户信息失败", DataCode.INVALIDERROR);
        }
        return new Result().success();
    }

    @RequestMapping(value = "queryCustomerByCondition.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "条件查询客户信息", notes = "条件查询客户信息", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "客户名称", dataType = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "客户电话", dataType = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "email", value = "客户邮箱", dataType = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "address", value = "客户地址", dataType = "String", required = false, paramType = "query")
    })
    public Result queryCustomerByCondition(CustomerCondition customerCondition, PageBean pageBean) {
        List<Customer> customerList = customerService.queryCustomerByCondition(customerCondition, pageBean);
        return new Result().success().add("customerList", customerList);
    }
}
