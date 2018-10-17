package com.unicom.mapper;

import com.unicom.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    User login(@Param("loginName") String loginName, @Param("password") String password);
}
