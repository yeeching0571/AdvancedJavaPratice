package com.JavaSenior.Generic.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 *
 * 1. 泛型在继承方面的体现
 *      类 A 是类 B 的父类， G<A> G<B> 不具备子父类关系。二者是并列关系。
 *      补充： 类 A 是类 B 的父类，A<G> 是 B<G> 的父类
 *
 * 2.通配符的使用
 *    通配符：？
 *    类 A 是类 B 的父类， G<A> G<B> 是没有关系的，二者共同的父类是：G<?>
 *
 * 3.有限制条件的通配符的使用
 *    ? extend A: G<? extends A> 可以作为 G<A> 和 G<B> 的父类，其中 B 是 A 的子类。 <=
 *    ? super A: G<? super A> 可以作为 G<A> 和 G<B> 的父类，其中 B 是 A 的父类。  >=
 *
 * @date 2023/11/30 21:44
 */
public class GenericTest1 {
    // 继承方面的体现一
    @Test
    public void test1(){
        // 泛型在继承方面的体现
        Object obj = null;
        String str = null;
        obj = str;
        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = null;
        // 此时 list1 和 list2 的类型不具有父子关系
//        list1 = list2;
    }

    // 继承方面的体现二
    @Test
    public void test2(){
        // 类 A 是类 B 的父类，A<G> 是 B<G> 的父类
        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;
    }

    // 通配符的使用
    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;

       //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;

        // 对于 List<?>，不能向其内部添加除 null 之外的数据。但允许读取，类型为 Object。
        list.add(null);
        Object o = list.get(0);
        System.out.println(o);
    }

    // 有限制条件的通配符的使用
    @Test
    public void test4(){
        List<? extends Person> list1 = null;
        List<? super Person> list2= null;

        List< Student> list3= null;
        List<Person> list4 = null;
        List<Object> list5 = null;

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        // 读取数据：
        list1 = list3;
        Person p = list1.get(0);
//        Student s = list1.get(0); //编译不通过
        Object obj = list2.get(0);
//        Person p1 = list2.get(0); //编译不通过

        // 写入数据
//        list1.add(new Student()); //编译不通过
        list2.add(new Person());
        list2.add(new Student());

    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }
}
