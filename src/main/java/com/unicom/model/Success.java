package com.unicom.model;

/**
 * 返回成功的json
 * zhengyangbo
 */
public class Success extends Json implements java.io.Serializable {

    public Success(String msg,Object obj){
        super(true,msg,obj);
    }

    public Success(String msg){
        super(true,msg,null);
    }
}
