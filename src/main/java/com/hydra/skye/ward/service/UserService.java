package com.hydra.skye.ward.service;

import com.hydra.skye.ward.model.result.DataResult;

/**
 * Created by yahto on 16/03/2018
 */
public interface UserService {
    DataResult login(String loginName, String password);
}
