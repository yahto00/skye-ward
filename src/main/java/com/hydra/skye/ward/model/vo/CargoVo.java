package com.hydra.skye.ward.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yahto on 26/03/2018
 */
public class CargoVo implements Serializable {

    private static final long serialVersionUID = -2917926356375259011L;

    private Long id;

    private Long dozenId;

    private Integer count;

    private Double totalArea;

    private Double price;

    private Date createAt;

    private Date updateAt;

    private String kindName;

    private String opUserName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getOpUserName() {
        return opUserName;
    }

    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName;
    }
}
