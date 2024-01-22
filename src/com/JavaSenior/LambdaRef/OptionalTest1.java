package com.JavaSenior.Updates;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 * @date 2023/12/30 18:34
 */
public class OptionalTest1 {

    @Test
    public void test1(){

        // empty(): 创建的Optional对象内部的value = null
        Optional<Object> op1 = Optional.empty();
        if (!op1.isPresent()){//Optional 封装的数据为空
            System.out.println("数据为空");
        }

        System.out.println(op1);
        System.out.println(op1.isPresent());

    }

    @Test
    public void test2(){

        String str = "hello";
        // of(T t): 封装数据 t 生成 Optional 对象。要求t非空，否则报错。
        Optional<String> op1 = Optional.of(str);

        // 通常与 of() 方法搭配使用，用于获取内部封装的数据 value
        //如果Optional封装的数据value为空，则get()报错。否则，value不为空时，返回value。
        String str1 = op1.get();
        System.out.println(str1);
    }

    @Test
    public void test3(){
        String str = "beijing";
        str = null;
        // ofNullable(T t): 封装数据t赋给Optional内部的value。不要求t非空
        Optional<String> op1 = Optional.ofNullable(str);
        //orElse(T t): 如果Optional内部的value非空，则返回此value值。如果value为空，则返回t1。
        String str2 = op1.orElse("shanghai");
        System.out.println(str2);
    }
}
