package com.unicom.model;

import java.io.Serializable;

/**
 * 返回错误类型
 * zhengyangbo
 */
public class ErrorJson extends Json implements Serializable {

    public ErrorJson(String msg, Object obj){
        super(false,msg,obj);
    }

    public ErrorJson(String msg){
        super(false,msg,null);
    }
}
