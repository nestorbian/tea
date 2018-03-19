package com.jstu.tea.util;

public class StringUtil {
    public static boolean isEmpty(String value) {
        if (value == null || value.length() <= 0 || value.trim() == "") {
            return false;
        }
        return true;
    }
}