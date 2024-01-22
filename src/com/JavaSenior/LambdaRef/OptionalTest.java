package com.JavaSenior.Updates;

import org.junit.Test;

import java.util.Optional;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 *
 * Optional类：为了在程序中避免空指针异常而设计的
 *
 * 1.创建Optional类对象的方法：
 *   Optional.of(T t) : 创建一个 Optional 实例， t必须非空；
 *   Optional.empty() : 创建一个空的 Optional 实例
 *   Optional.ofNullable(T t)
 *
 *
 * @date 2023/12/30 15:36
 */
public class OptionalTest {
    /*
     Optional.of(T t) : 创建一个 Optional 实例， t必须非空；
     Optional.empty() : 创建一个空的 Optional 实例
     Optional.ofNullable(T t)
     */

    @Test
    public void test1(){
        Girl girl = new Girl();
        // of(T t): 保证t是非空的
        Optional.of(girl);
    }

    @Test
    public void test2(){
        Girl girl = new Girl();
        girl =null;
        // ofNullable(T t): t 可以为 null
        //Optional.ofNullable(girl);
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

        // orElse(T t1): 如果当前的Optional 内部封装的 t 是非空的，则返回内部的t。
        //如果内部的t是空的，则返回orElse()方法中的参数t1。
        Girl girl1 = optionalGirl.orElse(new Girl("赵丽颖"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName); //空指针异常
    }

    //使用Optional的getGirlName():
    public String getGirlName1(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("王芳")));

        Girl girl = boy1.getGirl();

        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("李丽"));

        return girl1.getName();

    }

    @Test
    public void test4(){
        Boy boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }
}
