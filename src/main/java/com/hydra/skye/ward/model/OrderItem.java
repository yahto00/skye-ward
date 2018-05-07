package com.hydra.skye.ward.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yahto on 2018/5/6 7:15 PM
 */
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 3340242955884834444L;

    private Long id;

    private Long orderId;

    private Long cargoId;

    private Integer itemCount;

    private Double itemArea;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Double getItemArea() {
        return itemArea;
    }

    public void setItemArea(Double itemArea) {
        this.itemArea = itemArea;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
