package com.unicom.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AppUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 获取当前的时间戳
     * @return
     */
    public static String getNowTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmsss");//设置日期格式
        String date = df.format(new Date());
        return date;
    }
}
