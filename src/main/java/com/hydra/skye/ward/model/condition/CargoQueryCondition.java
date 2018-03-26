package com.hydra.skye.ward.model.condition;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by yahto on 26/03/2018
 */
public class CargoQueryCondition {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    private String kindName;
    private Integer count;
    private Double price;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
