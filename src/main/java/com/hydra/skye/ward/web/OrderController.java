package com.hydra.skye.ward.web;

import com.hydra.skye.ward.common.enums.DataCode;
import com.hydra.skye.ward.common.exception.BusinessException;
import com.hydra.skye.ward.model.Order;
import com.hydra.skye.ward.model.PageBean;
import com.hydra.skye.ward.model.condition.OrderQueryCondition;
import com.hydra.skye.ward.model.dto.OrderItemDto;
import com.hydra.skye.ward.model.result.Result;
import com.hydra.skye.ward.model.vo.OrderVo;
import com.hydra.skye.ward.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by yahto on 2018/5/6 7:34 PM
 */
@RequestMapping("/api/order")
@Controller
@Api(value = "订单管理", description = "订单API")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "createOrder.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "创建订单", notes = "创建订单", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerId", value = "客户ID", dataType = "Long", required = true, paramType = "query"),
    })
    public Result createOrder(@RequestBody List<OrderItemDto> orderItemDtoList,
                              @RequestParam("customerId") Long customerId,
                              HttpServletRequest request) {
        Integer totalCount = 0;
        Double totalArea = 0d;
        for (OrderItemDto dto : orderItemDtoList) {
            totalCount += dto.getItemCount();
            totalArea += dto.getItemArea();
        }
        Order order = new Order();
        order.setCreateAt(new Date());
        order.setCustomerId(customerId);
        order.setStatus(0);
        order.setTotalArea(totalArea);
        order.setTotalCount(totalCount);
        order.setUpdateAt(new Date());
//        User user = (User) request.getSession().getAttribute("current_user");
//        order.setLastOpUserId(user.getId());
        try {
            orderService.createOrder(order, orderItemDtoList);
        } catch (BusinessException e) {
            return new Result().fail(e.getMessage(), DataCode.SERVICEERROR);
        }
        return new Result().success();
    }

    @RequestMapping(value = "queryOrderByCondition.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "条件查询订单", notes = "条件查询订单", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerName", value = "客户名称", dataType = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "opsUserName", value = "操作人", dataType = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "createAt", value = "创建时间", dataType = "Date", required = false, paramType = "query"),
            @ApiImplicitParam(name = "endAt", value = "结束时间", dataType = "Date", required = false, paramType = "query"),
    })
    public Result queryOrderByCondition(OrderQueryCondition condition, PageBean pageBean) {
        List<OrderVo> orderVos = orderService.queryOrderByCondition(condition, pageBean);
        return new Result().success().add("orderVos", orderVos);
    }
}
