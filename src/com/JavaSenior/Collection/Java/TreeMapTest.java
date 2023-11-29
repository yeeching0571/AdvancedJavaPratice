package com.JavaSenior.Collection.Java;

import org.junit.Test;

import java.util.*;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * // 向 TreeMap 中添加 key-value, 要求 key 必须是由同一个类创建的对象
 * // 因为要按照 key 进行排序：自然排序、定制排序
 * @date 2023/11/24 22:37
 */
public class TreeMapTest {
    @Test
    public void test1(){
        // 自然排序
        TreeMap map = new TreeMap();
        Person p1 = new Person("Tom", 23);
        Person p2 = new Person("Jerry", 25);
        Person p3 = new Person("Mary", 34);
        Person p4 = new Person("Bob", 43);
        map.put(p1, 85);
        map.put(p2, 43);
        map.put(p3, 67);
        map.put(p4, 86);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }

    }

    @Test
    public void test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if( o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(),p2.getAge());
                }
                throw new RuntimeException("输入的类型不匹配");
            }
        });
        Person p1 = new Person("Tom", 23);
        Person p2 = new Person("Jerry", 25);
        Person p3 = new Person("Mary", 34);
        Person p4 = new Person("Bob", 43);
        map.put(p1, 85);
        map.put(p2, 43);
        map.put(p3, 67);
        map.put(p4, 86);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
