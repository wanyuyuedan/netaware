package com.unicom.service;

import com.unicom.model.User;

/**
 * 用户接口
 */
public interface UserService {

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    User login(String loginName, String password);
}
