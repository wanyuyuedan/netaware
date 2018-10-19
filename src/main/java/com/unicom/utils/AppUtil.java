package com.unicom.utils;

import java.util.UUID;

public class AppUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
