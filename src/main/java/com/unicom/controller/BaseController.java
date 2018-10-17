package com.unicom.controller;

import com.unicom.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://192.168.1.132:8080", maxAge = 3600)
@RestController
public class BaseController {

    private String SESSION_KEY = "session_user";
    /**
     * 获取当前登录的用户
     * @param req
     * @return
     */
    public User getSessionUser(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute(SESSION_KEY);
        return user;
    }

    /**
     * 保存会话
     * @param req
     * @param user
     */
    public void saveSessionUser(HttpServletRequest req,User user) {
        HttpSession session = req.getSession();
        session.setAttribute(SESSION_KEY, user);
    }

    @RequestMapping(
            value="/test",
            method = RequestMethod.GET
    )
    @ApiOperation(
            value = "接口文档测试"
    )
    public String test(){
        return "TEST";
    }

}
