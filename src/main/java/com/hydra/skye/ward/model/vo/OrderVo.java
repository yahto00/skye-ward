package com.hydra.skye.ward.model.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yahto on 2018/5/7 3:23 PM
 */
public class OrderVo implements Serializable {

    private static final long serialVersionUID = 8843410265472301420L;
    private Long orderId;
    private String customerName;
    private String customerPhone;
    private Double totalPrice;
    private Integer totalCount;
    private Double totalArea;
    private String opsUserName;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public String getOpsUserName() {
        return opsUserName;
    }

    public void setOpsUserName(String opsUserName) {
        this.opsUserName = opsUserName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
