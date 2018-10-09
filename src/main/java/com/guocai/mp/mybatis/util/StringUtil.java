package com.guocai.mp.mybatis.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 将符合驼峰标识的字符串转换为数据库字段格式
	 * @param str Ex. requestId -> REQUEST_ID
	 * @return
	 */
	public static String str2DbColumn(String str) {
		if (str==null ||str.trim().length()==0) return null;
		StringBuffer sb = new StringBuffer();		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if (c >= 'A' && c <= 'Z') {				
				sb.append("_" +String.valueOf(c));
			} else {
				sb.append(String.valueOf(c));
			}
		}
		return sb.toString().toUpperCase();
	}
	
	/**
	 * 将下划线变量转变为符合驼峰标识的变量
	 * @param param
	 * @return
	 */
	public static String underlineToCamel(String param){  
	       if (param==null||"".equals(param.trim())){  
	           return "";  
	       }
	       param = param.toLowerCase();
	       StringBuilder sb=new StringBuilder(param);  
	       Matcher mc= Pattern.compile("_").matcher(param);  
	       int i=0;  
	       while (mc.find()){  
	           int position=mc.end()-(i++);  
	           sb.replace(position-1,position+1,sb.substring(position,position+1).toUpperCase());  
	       }  
	       return sb.toString();  
	}
	
	/**
	 * 将符合驼峰标识的变量转换为下划线隔开的字符串
	 * @param param
	 * @return
	 */
	public static String camelToUnderline(String param){  
	       if (param==null||"".equals(param.trim())){  
	           return "";  
	       }  
	       int len=param.length();  
	       StringBuilder sb=new StringBuilder(len);  
	       for (int i = 0; i < len; i++) {  
	           char c=param.charAt(i);  
	           if (Character.isUpperCase(c)){  
	               sb.append("_");  
	               sb.append(Character.toLowerCase(c));  
	           }else{  
	               sb.append(c);  
	           }  
	       }  
	       return sb.toString().toUpperCase();  
	}  
	
	public static boolean isBlank(String str) {
		return str == null || str.trim().equals("");
	}
	
	

	/**
	 * @author dongweizhen
	 * @date 2014/7/21
	 * 
	 * @note : convert a string to date with YYYY-MM-dd
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static Date toYMDDate(String value) throws Exception {
		try {
			SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");
			Date dateResult = df1.parse(value);
			return dateResult;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	/**
	 * @author dongweizhen
	 * @date 2014/7/21
	 * 
	 * @note : convert a string to date with YYYY-MM-dd
	 * 
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static Date toYMDHMDDate(String value) throws Exception {
		try {
			SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHMMSS");
			Date dateResult = df1.parse(value);
			return dateResult;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串是否为数字
     */
    public static boolean isNumeric(String str) {
        return NumberUtils.isDigits(str);
    }
    
    /**
     * 判断字符串是否为数字
     */
    public static boolean isNumeber(String str) {
        return NumberUtils.isNumber(str);
    }

    /**
     * 正向查找指定字符串
     */
    public static int indexOf(String str, String searchStr, boolean ignoreCase) {
        if (ignoreCase) {
            return StringUtils.indexOfIgnoreCase(str, searchStr);
        } else {
            return str.indexOf(searchStr);
        }
    }

    /**
     * 反向查找指定字符串
     */
    public static int lastIndexOf(String str, String searchStr, boolean ignoreCase) {
        if (ignoreCase) {
            return StringUtils.lastIndexOfIgnoreCase(str, searchStr);
        } else {
            return str.lastIndexOf(searchStr);
        }
    }
    
    public static boolean isEmpty(Object obj) {
    	if(obj==null){
    		return false;
    	}
        String str = obj.toString().trim();
        
        return StringUtils.isEmpty(str);
    }
}
