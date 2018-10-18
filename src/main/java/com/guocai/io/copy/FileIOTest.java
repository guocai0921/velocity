package com.guocai.io.copy;

import org.junit.Test;

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
        // 关闭连接
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
    
    
    /**
     * @description: 
     * @auther: Sun GuoCai
     * @datetime: 2018/10/18 13:36
     * @param: tableName
     * @param: tablePrefix  
     * @return: java.lang.String
     */
    public static String getModuleName(String tableName, String tablePrefix) {
        String moduleName = null;
        if (tableName==null || tableName.trim().equals("")) return null;
        tableName = tableName.replace(tablePrefix, "");
        if (tableName.startsWith("_")) {
            tableName = tableName.substring(1);
        }
        int indexOf_ = tableName.indexOf("_");
        if(indexOf_>0){
            moduleName = tableName.substring(0, indexOf_);
        }else{
            moduleName=tableName.substring(0,tablePrefix.length()-1);
        }

        return moduleName;
    }

    @Test
    public void test(){

    }

}
