package com.guocai.io.copy;

import java.io.*;

/**
 * java类简单作用描述
 *
 * @ClassName: FileIOTest
 * @Package: com.guocai.io.copy
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/9/21 11:29
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class FileIOTest {

    public static void main(String[] args) {
        File oldFile = new File("D:\\idea\\images\\meinv.jpg");
        File newFile = new File("E:\\io\\file\\b.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(oldFile);
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream(newFile);
            bos = new BufferedOutputStream(fos);
            byte[] b = new byte[1024];
            int len ;
            while ((len = bis.read(b))!=-1){
                bos.write(b,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("复制完成!!!");
        }
    }

}
