package com.JavaSenior.Updates;

import com.JavaSenior.Reflection.Person;
import com.module1.PersonModule;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 *
 * 1.模块化本质上讲也就是说， 用模块来管理各个package，通过声明某个package暴露，模块(module)的概念，其实就是package外再裹一层， 不声明默
 * 认就是隐藏。因此，模块化使得代码组织上更安全，因为它可以指定哪些部分可以暴露，哪些部分隐藏。
 *
 * 2.模块将由通常的类和新的模块声明文件（module-info.java） 组成。 该文件是位于java代码结构的顶层， 该模块描述符明确地定义了我们的模块需要什么依赖关系，
 * 以及哪些模块被外部使用。 在exports子句中未提及的所有包默认情况下将封装在模块中，不能在外部使用。
 *
 * @date 2023/12/31 9:12
 */
public class ModuleTest {

    public static void main(String[] args) {
        PersonModule pm = new PersonModule("Tom", 23);
        System.out.println(pm);
    }
}
