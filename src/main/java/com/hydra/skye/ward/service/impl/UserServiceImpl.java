package com.hydra.skye.ward.service.impl;

import com.hydra.skye.ward.common.enums.DataCode;
import com.hydra.skye.ward.dao.UserDao;
import com.hydra.skye.ward.model.User;
import com.hydra.skye.ward.model.UserExample;
import com.hydra.skye.ward.model.result.Result;
import com.hydra.skye.ward.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahto on 16/03/2018
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Result login(String loginName, String password, HttpServletRequest request) {
        UserExample example = new UserExample();
        example.createCriteria().andLoginNameEqualTo(loginName);
        List<User> userList = userDao.selectByExample(example);
        if (CollectionUtils.isEmpty(userList)) {
            return new Result().fail("用户不存在", DataCode.SERVICEERROR);
        }
        User user = userList.get(0);
        if (!password.equals(user.getPassword())) {
            return new Result().fail("密码错误", DataCode.SERVICEERROR);
        }
        request.getSession().setAttribute("current_user", user);
        return new Result().success().add("user", user);
    }

    @Override
    public boolean updatePassword(User user, String newPassword) {
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(user.getId());
        List<User> userList = userDao.selectByExample(example);
        if (CollectionUtils.isEmpty(userList)) {
            return false;
        }
        if (userList.get(0).getPassword().equals(newPassword)) {
            return false;
        }
        return userDao.updatePassword(user.getId(), newPassword) > 0 ? true : false;
    }

    @Override
    public List<User> queryAllUser() {
        List<User> userList = userDao.queryAllUser();
        return userList == null ? new ArrayList<User>() : userList;
    }
}
