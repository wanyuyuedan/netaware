package com.unicom.model;

import java.io.Serializable;

/**
 * 返回错误类型
 * zhengyangbo
 */
public class Error extends Json implements Serializable {

    public Error(String msg,Object obj){
        super(false,msg,obj);
    }

    public Error(String msg){
        super(false,msg,null);
    }
}
