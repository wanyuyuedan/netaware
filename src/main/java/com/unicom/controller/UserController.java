package com.unicom.controller;

import com.unicom.model.Error;
import com.unicom.model.Json;
import com.unicom.model.Success;
import com.unicom.model.User;
import com.unicom.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户登录控制
 * zhengyangbo
 * @date 2018/10/17
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login")
    @ApiOperation(value="登录接口", notes="test:返回json格式，success=true为成功否则为失败")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "loginName", value = "登录账号", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "password", value = "登录密码", required = true, dataType = "String")
    })
    public Json login(User user, HttpServletRequest req){
        if(user==null || user.getLoginName()==null||user.getPassword()==null){
            return new Error("对不起，登录账号或密码不能为空！");
        }
        User u = userService.login(user.getLoginName(),user.getPassword());
        u.setPassword(null);
        if(u==null){
            return new Error("对不起，登录失败！");
        }else{
            super.saveSessionUser(req,u);
            return new Success("登录成功！",u);
        }
    }



}
