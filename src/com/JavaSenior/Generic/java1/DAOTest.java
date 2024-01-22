package com.JavaSenior.Generic.java1;

import org.junit.Test;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 * @date 2023/11/30 21:24
 */
public class DAOTest {
    @Test
    public void test1(){
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.add(new Customer());
    }

}
