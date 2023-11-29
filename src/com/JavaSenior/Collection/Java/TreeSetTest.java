package com.JavaSenior.Collection.Java;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * 1. 向 TreeSet 中添加的数据，要求是相同类的对象。需要指定排序方式。
 * 2. 两种排序方式：自然排序（实现 Comparable 接口） 和 定制排序（Comparator）
 *
 * 3. 自然排序中，比较两个对象是否相同的标准为：compareTo() 返回 0。不再是 equals()。
 * 4. 定制排序中，比较两个对象是否相同的标准为：compare() 返回 0。不再是 equals()。
 * @date 2023/8/9 10:23
 */

public class TreeSetTest {
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
//        set.add(2);
//        set.add(89);
//        set.add(-34);
//        set.add(27);

        set.add(new Person("Tom", 20));
        set.add(new Person("Andy", 32));
        set.add(new Person("Mike", 25));
        set.add(new Person("Lucas", 43));
        set.add(new Person("Tom", 23));



        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person)o1;
                    Person p2 = (Person)o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                }else {
                    throw  new RuntimeException("输入的对象类型不正确");
                }
            }
        };

        TreeSet set = new TreeSet(comparator);
        set.add(new Person("Tom", 20));
        set.add(new Person("Andy", 32));
        set.add(new Person("Bob", 25));
        set.add(new Person("Mike", 25));
        set.add(new Person("Lucas", 43));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
