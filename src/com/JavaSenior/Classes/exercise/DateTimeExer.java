package com.JavaSenior.Classes.exercise;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yeeching
 * @version 1.0
 * @description: 时间日期类的相关练习
 * @date 2023/8/2 16:37
 */
public class DateTimeExer {
    /*
     * 练习：字符串 “2020-09-08” 转换为 java.sql.Date
     */

    @Test
    public void dateTransfer() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2020-09-08");
        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }
}
