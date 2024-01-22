package com.JavaSenior.IOStream;

import org.junit.Test;

import java.io.*;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 *
 * 测试 FileInputStream 和 FileOutputStream 的使用
 *
 * 结论：
 * 1.对于文本文件(.txt .java .c .cpp)，使用字符流处理
 * 2.对于非文本文件(.jpg .mp3 .mp4 .doc .ppt)，使用字节流处理
 *
 * @date 2023/12/24 19:43
 */
public class FileInputOutputStream {
    /*
    实现对图片的复制
    */
    @Test
    public void testFileInputStream() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(".\\src\\com\\JavaSenior\\IOStream\\IOStream.jpg");
            File destFile = new File(".\\src\\com\\JavaSenior\\IOStream\\IOStream_copy.jpg");

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
