package com.JavaSenior.Generic.Exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * @date 2023/8/11 11:43
 */
public class EmployeeTest {

    //实现 comparable 接口，自然排序
    @Test
    public void test1(){

        TreeSet<Employee> set = new TreeSet<Employee>();

        Employee e1 = new Employee("Tom", 21, new MydDate(2002, 5, 9));
        Employee e2 = new Employee("Andy", 19, new MydDate(2004, 6, 29));
        Employee e3 = new Employee("Alice", 23, new MydDate(2000, 12, 7));
        Employee e4 = new Employee("Tommy", 22, new MydDate(2001, 11, 25));
        Employee e5 = new Employee("Tom", 20, new MydDate(2003, 3, 15));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        System.out.println(set.size());

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

            //foreach 遍历
//        for (Object em: set)
//        {
//            System.out.println(em.toString());
//        }
    }

//    创建 Comparator 对象，按生日日期的先后排序
    @Test
    public void test2(){
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

                MydDate b1 = o1.getBirthday();
                MydDate b2 = o2.getBirthday();

                return b1.compareTo(b2);
            }
        });

        Employee e1 = new Employee("Tom", 21, new MydDate(2002, 5, 29));
        Employee e2 = new Employee("Andy", 19, new MydDate(2002, 5, 29));
        Employee e3 = new Employee("Alice", 23, new MydDate(2000, 12, 7));
        Employee e4 = new Employee("Tommy", 22, new MydDate(2000, 12, 25));
        Employee e5 = new Employee("Tom", 20, new MydDate(2003, 3, 15));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
