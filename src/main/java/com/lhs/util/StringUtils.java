package com.lhs.util;

public class StringUtils {
    public static boolean isEmpty(String val) {
        return val == null || val == "" || val.trim() == "";
    }

    public static boolean notEmpty(String val) {
        return !isEmpty(val);
    }

}
