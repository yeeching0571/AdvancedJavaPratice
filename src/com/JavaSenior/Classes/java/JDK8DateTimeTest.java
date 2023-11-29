package com.JavaSenior.Classes.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * 1. LocalDate、 LocalTime、 LocalDateTime 的使用及常见方法 LocalDateTime.now()
 * 2. Instant 的使用及其方法 now()、ofEpochMilli()、toEpochMilli()、atOffset()
 * 3. DateTimeFormatter：格式化或解析日期、时间，类似于 SimpleDateFormat
 *    格式化方式一：预定义的标准格式，如ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
 *    格式化方式二：本地化相关的格式，如：ofLocalizedDateTime(FormatStyle.LONG)、ofLocalizedDate()、ofLocalizedTime()
 *    格式化方式三（重点）：自定义的格式,如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
 * @date 2023/8/2 17:43
 */
public class JDK8DateTimeTest {
    /**
     LocalDate、 LocalTime、 LocalDateTime 的使用及常见方法
    */
    @Test
    public void test1(){
        // now() 获取当前日期/时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        // of()：设置指定的年月日时分秒，没有偏移量
        System.out.println("**************************");
        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 8, 2, 17, 51);
        System.out.println(localDateTime1);

        //getXxx()：获取相关属性
        System.out.println("**************************");
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());

        //withXxx()：设置相关属性  体现不可变性
        System.out.println("**************************");
        LocalDate localDate1 = localDate.withDayOfMonth(5);
        System.out.println(localDate);
        System.out.println(localDate1);

        //plusXxx()
        System.out.println("**************************");
        LocalDate localDate2 = localDate.plusMonths(2);
        System.out.println(localDate);
        System.out.println(localDate2);

        //minusXxx()
        System.out.println("**************************");
        LocalDate localDate3 = localDate.minusYears(-1);
        System.out.println(localDate);
        System.out.println(localDate3);

    }

    /**
    Instant 的使用
    */
    @Test
    public void test2(){
        //now() 获取的是零时区的时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8)); //东八区
        System.out.println(offsetDateTime);

        //toEpochMilli()：获取自 1970:01:01:00:00:00(UTC)开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        Instant instant1 = Instant.ofEpochMilli(milli);
        System.out.println(instant1);
    }

    /**
     DateTimeFormatter的使用
    */
    @Test
    public void test3(){
        System.out.println("*************格式化方式一*************");
        //格式化方式一：预定义的标准格式，如ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        //格式化：日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str);
        //解析：字符串 --->日期
        TemporalAccessor parse = formatter.parse(str);
        System.out.println(parse);


        //格式化方式二：方式二：本地化相关的格式，如：ofLocalizedDateTime(FormatStyle.LONG)、ofLocalizedDate()、ofLocalizedTime()
        System.out.println("\n*************格式化方式二*************");
        //格式化：日期 --> 字符串
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str1 = formatter1.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);
        //解析：字符串 --->日期
        TemporalAccessor parse1 = formatter1.parse(str1);
        System.out.println(parse1);


        //方式三：自定义的格式,如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        System.out.println("\n*************格式化方式三*************");
        //格式化：日期 --> 字符串
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str2 = formatter2.format(LocalDateTime.now());
        System.out.println(str2);
        //解析：字符串 --->日期
        System.out.println(formatter2.parse(str2));

    }

}
