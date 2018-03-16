package com.hydra.skye.ward.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 2916488747073980722L;

    private Long id;

    private String username;

    private String loginName;

    @JSONField(serialize = false)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}