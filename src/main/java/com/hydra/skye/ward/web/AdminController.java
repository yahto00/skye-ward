package com.hydra.skye.ward.web;

import com.google.common.base.Preconditions;
import com.hydra.skye.ward.common.enums.DataCode;
import com.hydra.skye.ward.model.User;
import com.hydra.skye.ward.model.result.Result;
import com.hydra.skye.ward.service.UserService;
import com.hydra.skye.ward.util.PasswordUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yahto on 16/03/2018
 */
@RequestMapping("/api/user")
@Controller
@Api(value = "用户管理", description = "用户API")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户登录", notes = "用户登录", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName", value = "登录账号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "登录密码", required = true, paramType = "query")
    })
    public Result login(@RequestParam("loginName") String loginName,
                        @RequestParam("password") String password,
                        HttpServletRequest request) {
        Preconditions.checkNotNull(loginName);
        Preconditions.checkNotNull(password);
        return userService.login(loginName, PasswordUtil.encrypt(password), request);
    }

    @RequestMapping(value = "/updatePassword.ajax", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户修改密码", notes = "用户修改密码", response = Result.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "newPassword", value = "新密码", required = true, paramType = "query"),
    })
    public Result updatePassword(@RequestParam("newPassword") String newPassword,
                                 HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("current_user");
        if (user == null) {
            return new Result().fail("用户未登录", DataCode.NOLOGIN);
        }
        if (!userService.updatePassword(user, PasswordUtil.encrypt(newPassword))) {
            return new Result().fail("修改密码失败", DataCode.DATABASEERROR);
        }
        return new Result().success();
    }

    @RequestMapping(value = "queryAllUser.ajax",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "查询所有用户", notes = "查询所有用户", response = Result.class)
    public Result queryAllUser(){
        List<User> userList = userService.queryAllUser();
        return new Result().success().add("userList",userList);
    }
}
