package com.JavaSenior.Classes.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yeeching
 * @version 1.0
 * @description: JDK8.0之前，日期和时间的 API 测试
 * @date 2023/7/27 15:59
 */
public class DateTimeTest {
    /**
    java.util.Date类
            |---java.sql.Date类
    1. 两个构造器的使用
        ->构造器一：Date(): 创建一个当前时间的 Date 对象
        ->构造器二： 创建指定毫秒数的 Date 对象
    2. 两个方法的使用
        ->toString(): 显示当前的年月日时分秒
        ->getTime(): 获取当前 Date 对象对应的毫秒数。（时间戳）
    3. java.sql.Date 对应着数据库中的日期类型的变量
        ->如何实例化
        ->如何将 java.sql.Date 对象转换为 java.util.Date 对象
    4. System 类中的 currentTimeMillis(),返回以毫秒为单位的时间戳

    5. SimpleDateFormat: 对日期 Date 类的格式化和解析
       1) 格式化：Date ---> String，  format()
       2) 解析：String ---> Date，   parse()

    */
    @Test
    public void test2(){
        //构造器一：Date(): 创建一个当前时间的 Date 对象
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        //构造器二： 创建指定毫秒数的 Date 对象
        Date date2= new Date(1690445664994L);
        System.out.println(date2.toString());

        java.sql.Date date3 = new java.sql.Date(1690445664994L);
    }

    //1. System 类中的 currentTimeMillis(),返回以毫秒为单位的时间戳
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }

    @Test
    public void testSimpleDateFormate() throws ParseException {
        // 实例化 SimpleDateFormat，使用默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 ---> 字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串 ---> 日期
        String str = "2023/8/2 下午3:55"; // SimpleDateFormat 的默认格式
        Date data1 = sdf.parse(str);
        System.out.println(data1);

        //按照指定的方式格式化和解析：调用带参数的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析
        Date date2 = sdf1.parse("2023-08-02 03:59:32");
        System.out.println(date2);
    }

}
