package com.hydra.skye.ward.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Cargo implements Serializable {

    private static final long serialVersionUID = 8160396719347033305L;

    private Long id;

    private Long lastOpUserId;

    private Long dozenId;

    private Integer count;

    private Double totalArea;

    private Double price;

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

    public Long getLastOpUserId() {
        return lastOpUserId;
    }

    public void setLastOpUserId(Long lastOpUserId) {
        this.lastOpUserId = lastOpUserId;
    }

    public Long getDozenId() {
        return dozenId;
    }

    public void setDozenId(Long dozenId) {
        this.dozenId = dozenId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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