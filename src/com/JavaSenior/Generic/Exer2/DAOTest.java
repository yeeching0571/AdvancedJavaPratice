package com.JavaSenior.Generic.Exer2;

import java.util.List;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 * @date 2023/12/6 17:40
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<User>();
        dao.save("1001", new User(1,"Tom", 23));
        dao.save("1002", new User(2,"Jack", 21));
        dao.save("1003", new User(3,"Leo", 18));
        dao.update("1003", new User(3,"Mike", 24));
        dao.delete("1002");

        List<User> list = dao.list();
        list.forEach(System.out :: println);
    }
}
