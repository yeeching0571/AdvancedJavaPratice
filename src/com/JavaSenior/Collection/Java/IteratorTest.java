package com.JavaSenior.Collection.Java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * 集合元素的遍历操作，使用迭代器和 Iterator 接口
 * 1. 内部的方法：hasNext() 和 next()
 * 2. 集合对象每次调用 iterator() 方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。
 * 3. 内部定义了 remove()，可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用 remove()。
 * @date 2023/8/8 16:07
 */
public class IteratorTest {
    //iterator()
    @Test
    public void test(){
        Collection coll1 = new ArrayList();
        coll1.add("AA");
        coll1.add("BB");
        coll1.add(123);//自动装箱
        coll1.add(new Date());

        //iterator(): 返回 Iterator 接口的实例，用于遍历集合元素。放在 IteratorTest.java 中
        Iterator iterator = coll1.iterator();
        //遍历方法一：不推荐
//        for (int i = 0; i < coll1.size(); i++) {
//            System.out.println(iterator.next());
//        }
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //测试 Iterator 中的 remove()
        Iterator iterator1 = coll1.iterator();
        while (iterator1.hasNext()){
            Object obj = iterator1.next();
            if ("AA".equals(obj)){
                iterator1.remove();
            }
        }

        Iterator iterator2 = coll1.iterator();
        System.out.println("\n***************************");
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }

}
