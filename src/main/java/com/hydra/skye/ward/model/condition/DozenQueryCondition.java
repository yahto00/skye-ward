package com.hydra.skye.ward.model.condition;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by yahto on 20/03/2018
 */
public class DozenQueryCondition {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endAt;
    private String kindName;
    private String username;
    private String number;

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getEndAt() {
        return endAt;
    }

    public void setEndAt(Date endAt) {
        this.endAt = endAt;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
