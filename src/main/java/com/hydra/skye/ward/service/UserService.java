package com.hydra.skye.ward.service;

import com.hydra.skye.ward.model.User;
import com.hydra.skye.ward.model.result.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yahto on 16/03/2018
 */
public interface UserService {
    Result login(String loginName, String password, HttpServletRequest request);

    boolean updatePassword(User user, String newPassword);

    List<User> queryAllUser();
}
