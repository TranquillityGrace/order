package com.wyy.order.utils;

import java.util.Random;

/**
 * 生成唯一主键
 *
 * @Author WYY
 * @Date 2019-08-13 15:42
 */
public class KeyUtil {

    /**
     * 时间+随机数
     * @return
     */
    public static synchronized String generateUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt() + 90000;
        return System.currentTimeMillis() + String.valueOf(number);
    }

}
