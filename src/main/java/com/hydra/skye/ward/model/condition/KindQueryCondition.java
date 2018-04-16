package com.hydra.skye.ward.model.condition;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by yahto on 15/04/2018 8:26 PM
 */
public class KindQueryCondition {
    private String kindName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createAt;

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
