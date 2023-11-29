package com.JavaSenior.Classes.exercise;

import org.junit.Test;

/**
 * @author yeeching
 * @version 1.0
 * @description:TODO
 * @date 2023/8/2 11:02
 */
public class IDEADebug {

    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length()); //4
        System.out.println(sb); // "null"

        StringBuffer sb1 = new StringBuffer(str);//抛异常 NullPointerExcewption
        System.out.println(sb1);
    }
}
