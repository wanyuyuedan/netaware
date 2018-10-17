package com.unicom.model;

/**
 * 返回成功的json
 * zhengyangbo
 */
public class SuccessJson extends Json implements java.io.Serializable {

    public SuccessJson(String msg, Object obj){
        super(true,msg,obj);
    }

    public SuccessJson(String msg){
        super(true,msg,null);
    }
}
