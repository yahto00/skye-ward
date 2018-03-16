package com.hydra.skye.ward.service.impl;

import com.hydra.skye.ward.dao.UserDao;
import com.hydra.skye.ward.model.User;
import com.hydra.skye.ward.model.UserExample;
import com.hydra.skye.ward.model.result.DataResult;
import com.hydra.skye.ward.model.result.FailResult;
import com.hydra.skye.ward.model.result.SuccessResult;
import com.hydra.skye.ward.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by yahto on 16/03/2018
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public DataResult login(String loginName, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andLoginNameEqualTo(loginName);
        List<User> userList = userDao.selectByExample(example);
        if (CollectionUtils.isEmpty(userList)) {
            return new FailResult("用户不存在");
        }
        User user = userList.get(0);
        if (!password.equals(user.getPassword())) {
            return new FailResult("密码错误,请重新登录");
        }
        return new SuccessResult(user);
    }
}
