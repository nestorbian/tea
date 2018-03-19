package com.jstu.tea.util;

import java.util.UUID;

public class IdUtil {
    public static String getUUID(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }
}
