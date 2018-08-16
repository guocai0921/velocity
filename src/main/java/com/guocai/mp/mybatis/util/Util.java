package com.guocai.mp.mybatis.util;

import org.dom4j.Document;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * java类简单作用描述
 *
 * @ClassName: Util
 * @Package: com.guocai.mp.util
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/27 12:32
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class Util {

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
		//logger.debug(sb.toString());
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
	/**
	 * 从表名中分离业务模块的名称（表明命名规则：tablePrefix_module_tableName）
	 * tablePrefix一般以项目缩写命名，module根据业务模块缩写命名
	 * @param tableName
	 * @param tablePrefix
	 * @return
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
	 * 首字母变大写
	 * @param word
	 * @return
	 */
	public static String firstLetterToUpper(String word) {
		char[] array = word.toCharArray();
		array[0] -= 32;
		return String.valueOf(array);
	}
	/**
	 * 格式化XML
	 * @param doc
	 * @return
	 * @throws Exception
	 */
	public static String formatXML(Document doc) {
		StringWriter out=null;
		try{
			org.dom4j.io.OutputFormat formate= org.dom4j.io.OutputFormat.createPrettyPrint();
			out=new StringWriter();
			XMLWriter writer=new XMLWriter(out,formate);
			writer.write(doc);
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return out.toString();
	}

	public static void main(String[] args) {
		Util.underlineToCamel("STOCK_DATA_PRIVILEGE");
		Util.camelToUnderline("stockDataPrivilege");
	}
}
