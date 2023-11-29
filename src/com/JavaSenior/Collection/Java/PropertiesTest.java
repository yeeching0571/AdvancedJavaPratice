package com.JavaSenior.Collection.Java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * Properties: 常用来处理配置文件，key 和 value 都是 String 类型
 * @date 2023/11/27 21:57
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis); //加载流对应的文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name = " + name + " password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
