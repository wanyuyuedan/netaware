package com.unicom.model;

import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 用户实体
 * zhengyangbo
 */
public class User implements Serializable {

    private Integer id;//id
    private String loginName;//登录账号
    @JSONField(serialize=false)
    private String password;//登录密码
    private String userName;//姓名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
