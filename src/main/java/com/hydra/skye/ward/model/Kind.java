package com.hydra.skye.ward.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class Kind implements Serializable {

    private static final long serialVersionUID = -1526510553122118836L;

    private Long id;

    private String name;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
}