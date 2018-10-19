package com.guocai.io.copy;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.junit.Test;

import java.io.*;
import java.time.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * @description:
     * @auther: Sun GuoCai
     * @datetime: 2018/10/18 21:05
     * @param: str
     * @return: java.lang.String
     */
    public static String validateString(String str){
        /*
            L：字母；
            P：标点字符；
            M：标记符号（一般不会单独出现）；
            Z：分隔符（比如空格、换行等）；
            S：符号（比如数学符号、货币符号等）；
            N：数字（比如阿拉伯数字、罗马数字等）；
            C：其他字符
        */
        String newStr = null;
        if ( str.contains("/")) {
            str = str.replace("/","_");
        } else if (str.contains("__")) {
            str = str.replace("__","\\_");
        }
        newStr = str;
        return  newStr.trim();
    }

    @Test
    public void test(){

        // String str = "!!！？？!!!!%*）!@#$%^&*()%￥！@#￥%……&**（）！KTV去符号标号！！当然,，。!!..**半角";
        // System.out.println(str);
        // String str1 = str.replaceAll("[\\pP\\p{Punct}]", "");
        // System.out.println("str1:" + str1);
        //
        //
        // String str2 = str.replaceAll("[\\pP]|[￥$^~]", "");
        // System.out.println("str2:" + str2);


        // String str = "service@xsoftlab.net";
        // // 邮箱验证规则
        // String regEx = "[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        // // 编译正则表达式
        // Pattern pattern = Pattern.compile(regEx);
        // // 忽略大小写的写法
        // // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        // Matcher matcher = pattern.matcher(str);
        // // 字符串是否与正则表达式相匹配
        // boolean rs = matcher.matches();
        // System.out.println(rs);

        // String str = "嗨s    2u3！n你海风3g    好， 这u23世 3o界c3真a 3没  3i。";
        // char[] chars = str.toCharArray();
        // String regEx = "[a-zA-Z]";
        // Pattern pattern = Pattern.compile(regEx);
        // int num = 0;
        //
        // for (int i = 0; i < chars.length; i++) {
        //     Matcher matcher = pattern.matcher(String.valueOf(chars[i]));
        //     if (matcher.matches()) {
        //         num++;
        //     }
        // }
        // System.out.println("num = " + num);
        //
        // String newStr = str.replaceAll("[\\pP]","")
        //         .replaceAll("[0-9]","")
        //         .replaceAll("[\\u4e00-\\u9fa5]","").trim()
        //         .replaceAll("[\\s]+","_");
        //         //.replaceAll("[\\s]","$");
        // System.out.println("newStr = " + newStr);

        Instant inst1 = Instant.now();
        for (int i=0;i<10;i++) {
            System.out.println("i = " + i);

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant inst2 = Instant.now();
        System.out.println("Difference in milliseconds : " + Duration.between(inst1, inst2).toMillis());
        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());

    }

}
