package com.seed.util.servlet;

import org.springframework.util.StringUtils;

public class CheckUtil {
    /**
     * 验证是否有空值的参数，只要有一个，就返回true
     *
     * @param args
     * @return true
     */
    public static boolean checkNulls(String... args) {

        if (args.length == 0) {
            return true;
        }
        //
        for (String str : args) {
            if (StringUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }
}
