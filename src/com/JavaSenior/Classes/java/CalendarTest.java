package com.JavaSenior.Classes.java;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * 1. 实例化
 *  方式一：创建其子类 (GregorianCalendar) 的对象
 *  方式二：调用其静态方法 getInstance()
 *
 * 2. 常用方法 get(), set(), add(), getTime(), setTime()
 * 注意：获取月份时，一月是0，二月是1，以此类推。获取星期时，周日是1，周一是2，以此类推。
 * @date 2023/8/2 16:52
 */
public class CalendarTest {
    @Test
    public void testCalendar(){
        //实例化
        Calendar calendar = Calendar.getInstance();

        //常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 5);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-2);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime()
        Date date = calendar.getTime();
        System.out.println(date);

        //getTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

    }
}
