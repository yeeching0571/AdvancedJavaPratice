package com.JavaSenior.Collection.Exer;

import com.JavaSenior.Collection.Java.TreeSetTest;
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
        TreeSet set = new TreeSet();

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

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

            //foreach 遍历
//        for (Object em: set)
//        {
//            System.out.println(em.toString());
//        }
    }

    //创建 Comparator 对象，按生日日期的先后排序
    @Test
    public void test2(){
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MydDate b1 = e1.getBirthday();
                    MydDate b2 = e2.getBirthday();

                    //比较年
                    int minusYear = b1.getYear() - b2.getYear();
                    if (minusYear != 0){
                        return minusYear;
                    }

                    //比较月
                    int minusMonth = b1.getMonth() - b2.getMonth();
                    if(minusMonth != 0){
                        return minusMonth;
                    }

                    //比较日
                    int minusDay = b1.getDay() - b2.getDay();
                    if(minusDay != 0){
                        return minusDay;
                    }
                    return 0;
                }
                throw new RuntimeException("传入的数据类型不一致");
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

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
