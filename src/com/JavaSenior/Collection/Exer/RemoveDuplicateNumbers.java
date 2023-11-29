package com.JavaSenior.Collection.Exer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author yeeching
 * @version 1.0
 * @description: remove the duplicate numbers in a list
 * @date 2023/11/18 22:44
 */
public class RemoveDuplicateNumbers {
    public static List removeDuplicateNumbers(List list){
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(4);
        list = removeDuplicateNumbers(list);
        System.out.println(list);
    }
}

