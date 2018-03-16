package com.hydra.skye.ward.web;

import com.google.common.base.Preconditions;
import com.hydra.skye.ward.model.result.DataResult;
import com.hydra.skye.ward.service.UserService;
import com.hydra.skye.ward.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yahto on 16/03/2018
 */
@RequestMapping("/api/user")
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.ajax", method = RequestMethod.POST)
    @ResponseBody
    public DataResult login(@RequestParam("loginName") String loginName,
                            @RequestParam("password") String password) {
        Preconditions.checkNotNull(loginName);
        Preconditions.checkNotNull(password);
        return userService.login(loginName, PasswordUtil.encrypt(password));
    }
}
