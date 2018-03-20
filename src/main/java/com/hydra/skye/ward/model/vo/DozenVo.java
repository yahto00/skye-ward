package com.hydra.skye.ward.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yahto on 20/03/2018
 */
public class DozenVo implements Serializable {

    private static final long serialVersionUID = 618304899960860222L;

    private Long id;

    private String number;

    private Integer totalCount;

    private Integer leftCount;

    private Double totalArea;

    private Double leftArea;

    private Date createAt;

    private String opUserName;

    private String kindName;

    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getOpUserName() {
        return opUserName;
    }

    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
