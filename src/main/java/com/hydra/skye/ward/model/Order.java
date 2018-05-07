package com.hydra.skye.ward.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yahto on 2018/5/6 7:20 PM
 */
public class Order implements Serializable {

    private static final long serialVersionUID = -6240892950669039026L;

    private Long id;

    private Long customerId;

    private Long lastOpUserId;

    private Double totalPrice;

    private Integer totalCount;

    private Double totalArea;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getLastOpUserId() {
        return lastOpUserId;
    }

    public void setLastOpUserId(Long lastOpUserId) {
        this.lastOpUserId = lastOpUserId;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
