package com.JavaSenior.Generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 *
 * jdk5.0 新增特性
 * 泛型，就是允许在定义类、 接口时通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。这个类型参数将在使用时（例如，
 * 继承或实现这个接口， 用这个类型声明变量、 创建对象时） 确定（即传入实际的类型参数， 也称为类型实参）。
 *
 * 引入原因： ① 为了类型安全 ② 避免在强制转换时，出现 ClassCastException
 *
 *总结：
 *① 集合接口或集合类在 jdk5.0 时都修改为带泛型的结构。
 *② 在实例化集合类时，可以指明泛型的类型
 *③ 指明完之后，在集合类或接口中定义类/接口时，内部结构(方法、构造器、属性等)使用到类的泛型位置，都会指定为实例化泛型类型。
 *    比如： add(E e) ---> 实例化之后 add(Integer e)
 *④ 注意点：泛型的类型必须是类，不能是基本数据类型。如需用基本类型，则使用包装类替换。
 *
 * @date 2023/11/28 14:08
 */
public class GenericTest {
    @Test // 以 ArrayList 为例
    public void test1(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(23);
        list.add(17);
        list.add(9);
        list.add(78);
        // 编译时，就会进行类型检查，保证数据的安全
//        list.add("str");

        // 方式一
//        for(Integer score: list){
//            //避免强制转换类型操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        // 方式二
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    @Test // 以 HashMap 为例
    public void tes2(){
        HashMap <String, Integer> map = new HashMap<String, Integer>();

        map.put("Tom", 78);
        map.put("Jane", 85);
        map.put("Tony", 83);
    }
}
