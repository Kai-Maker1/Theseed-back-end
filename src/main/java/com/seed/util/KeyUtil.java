package com.seed.util;

import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数（六位）
     * 为防止多线程并发时出现id重复  该方法加关键字synchronized
     * @return
     */
    //regularPrefix 主键最前面的固定字符，学生学号，教师职工号允许为空
    private static String regularPrefix;

    public static synchronized String getUniqueKey(String prefix) {
        regularPrefix=prefix;
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        System.out.println(System.currentTimeMillis());
        return regularPrefix+System.currentTimeMillis() + String.valueOf(number);

    }
}
