package com.JavaSenior.Collection.Java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author yeeching
 * @version 1.0
 * @description: JDK5.0 新增了 foreach 循环，用于遍历集合、数组
 * for (集合元素的类型  局部变量: 集合对象)
 *
 * @date 2023/8/8 16:15
 */
public class ForeachTest {

    @Test
    public void test1(){
        Collection coll1 = new ArrayList();
        coll1.add("AA");
        coll1.add("BB");
        coll1.add(123);//自动装箱
        coll1.add(new Date());

        //for (集合元素的类型  局部变量: 集合对象)
        for (Object obj: coll1) {
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1, 2, 3, 4, 5};

        //for (集合元素的类型  局部变量: 数组对象)
        for (int item: arr) {
            System.out.println(item);
        }
    }

    //练习 foreach 与 for 遍历数组的区别
    @Test
    public void test3(){
        String[] strs = new String[]{"GG", "GG","GG"};

        // 直接修改数组的数据
//        for (int i = 0; i < strs.length; i++) {
//            strs[i] = "MM";
//        }

        //不修改原数组
        for (String str: strs) {
            str = "MM";
        }

        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
    }
}
