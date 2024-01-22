package com.JavaSenior.IOStream;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Date;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 *
 * File 类的使用
 * File 类的一个对象，代表一个文件或一个文件目录（俗称：文件夹），声明在 java.io 包下
 * File 类中涉及到关于文件或者目录的创建、删除、重命名、修改时间、文件大小等方法，并未涉及到写入或读取文件内容的操作。
 *      如果需要读取或者写入文件内容，必须使用 IO 流来完成。
 *
 * 1.如何创建 File 类的实例
 *     public File(String pathname)
 *     public File(String parent, String child)
 *     public File(File parent, String child)
 *
 * 2.路径分隔符
 *     windows和 DOS系统默认使用“\”来表示
 *     UNIX和 URL使用“/”来表示
 *
 * 3.File 类获取功能
 *     public String getAbsolutePath()： 获取绝对路径
 *     public String getPath() ： 获取路径
 *     public String getName() ： 获取名称
 *     public String getParent()： 获取上层文件目录路径。 若无， 返回null
 *     public long length() ： 获取文件长度（即：字节数） 。 不能获取目录的长度。
 *     public long lastModified() ： 获取最后一次的修改时间， 毫秒值
 *    如下方法适用于文件目录
 *     public String[] list() ： 获取指定目录下的所有文件或者文件目录的名称数组
 *     public File[] listFiles() ： 获取指定目录下的所有文件或者文件目录的 File 数组
 *
 * 4. File 类判断功能
 *     public boolean isDirectory()： 判断是否是文件目录
 *     public boolean isFile() ： 判断是否是文件
 *     public boolean exists() ： 判断是否存在
 *     public boolean canRead() ： 判断是否可读
 *     public boolean canWrite() ： 判断是否可写
 *     public boolean isHidden() ： 判断是否隐藏
 *
 * 5. File 类的创建功能
 *     public boolean createNewFile() ： 创建文件。 若文件存在， 则不创建， 返回 false
 *     public boolean mkdir() ： 创建文件目录。 如果此文件目录存在， 就不创建了。如果此文件目录的上层目录不存在， 也不创建。
 *     public boolean mkdirs() ： 创建文件目录。 如果上层文件目录不存在， 一并创建。
 *      注意事项：如果你创建文件或者文件目录没有写盘符路径， 那么， 默认在项目路径下。
 *
 * 6. File 类的删除功能
 *     public boolean delete()： 删除文件或者文件夹
 *      删除注意事项：Java中的删除不走回收站。要删除一个文件目录， 请注意该文件目录内不能包含文件或者文件目录。
 *
 * @date 2023/12/6 18:08
 */
public class FileTest {

    @Test
    public void test1(){
        // 构造器1
        File file1 = new File("D:\\JavaFiles\\AdvancedJavaPratice\\src" +
                "\\com\\JavaSenior\\IOStream\\hello.txt");
        //Windows 和 DOS系统
        File file2 = new File("d:" + File.separator + "JavaFiles" + File.separator + "AdvancedJavaPratice"+ File.separator +"src"
                + File.separator + "com" + File.separator + "JavaSenior" + File.separator + "IOStream"+ File.separator +"hello.txt");
        System.out.println(file1);
        System.out.println(file2);

        // 构造器2
        File file3 = new File("D:\\JavaFiles\\AdvancedJavaPratice","files");
        System.out.println(file3);

        // 构造器3
        File file4 = new File(file3, "test.txt");
        System.out.println(file4);
    }

    // File 类获取方法
    @Test
    public void test2(){
        File file1 = new File("D:\\JavaFiles\\AdvancedJavaPratice\\src" +
                "\\com\\JavaSenior\\IOStream\\hello.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getParent());
        System.out.println(file1.getName());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
    }

    @Test
    public void test3(){
        File file1 = new File("D:\\JavaFiles\\AdvancedJavaPratice");
        String[] list = file1.list();
        for(String s: list){
            System.out.println(s);
        }
    }

    @Test
    public void test4(){
        File file2 = new File("D:\\JavaFiles\\AdvancedJavaPratice\\src" +
                "\\com\\JavaSenior\\IOStream\\hello.txt");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());
    }

    @Test
    public void test5() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            file1.createNewFile();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }
    }
}
