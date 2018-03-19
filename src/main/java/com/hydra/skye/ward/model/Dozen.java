package com.hydra.skye.ward.model;

import java.io.Serializable;
import java.util.Date;

public class Dozen implements Serializable {

    private static final long serialVersionUID = 5011743832077249589L;

    private Long id;

    private Long kindId;

    private Long lastOpUserId;

    private String number;

    private Integer totalCount;

    private Integer leftCount;

    private Double totalArea;

    private Double leftArea;

    private Date createAt;

    private Date updateAt;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKindId() {
        return kindId;
    }

    public void setKindId(Long kindId) {
        this.kindId = kindId;
    }

    public Long getLastOpUserId() {
        return lastOpUserId;
    }

    public void setLastOpUserId(Long lastOpUserId) {
        this.lastOpUserId = lastOpUserId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getLeftCount() {
        return leftCount;
    }

    public void setLeftCount(Integer leftCount) {
        this.leftCount = leftCount;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public Double getLeftArea() {
        return leftArea;
    }

    public void setLeftArea(Double leftArea) {
        this.leftArea = leftArea;
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