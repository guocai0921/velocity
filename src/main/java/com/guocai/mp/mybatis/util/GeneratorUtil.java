package com.guocai.mp.mybatis.util;

import com.guocai.mp.mybatis.entity.Column;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import java.io.*;

/**
 * java类简单作用描述
 *
 * @ClassName: GeneratorUtil
 * @Package: com.guocai.mp.util
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/27 11:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class GeneratorUtil {
	/**
	 * 根据模板生成文件
	 * @param templateFile
	 * @return
	 * @throws IOException
	 */
	public static String generate(VelocityContext velocityCtx, String templateFile) {
		StringWriter stringWriter=null;
		try {
			templateFile = Constants.TEMPLATE_PATH+ Constants.FILE_SEPERATOR + templateFile;
//			logger.debug(templateFile);
			InputStream in = new FileInputStream(templateFile);
			InputStreamReader read = new InputStreamReader(in, "UTF-8");
			BufferedReader reader = new BufferedReader(read);
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			read.close();

			stringWriter = new StringWriter();
			VelocityEngine velocityEngine = new VelocityEngine();
			velocityEngine.evaluate(velocityCtx, stringWriter, "", sb.toString());
			stringWriter.flush();
			stringWriter.close();
		} catch (ParseErrorException e) {
			e.printStackTrace();
		} catch (MethodInvocationException e) {
			e.printStackTrace();
		} catch (ResourceNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return String.valueOf(stringWriter==null?"":stringWriter);
	}



	public static void writeFile(String content, String path, String fileName, boolean overWrite) {
		File file=new File(path);
		try {
			if(!file.exists()) {
				file.mkdirs();
				file=new File(path + Constants.FILE_SEPERATOR + fileName);
				//logger.debug("Generate file " + file);
				if(!file.exists())  file.createNewFile();
				FileOutputStream out=new FileOutputStream(file,true);
				out.write(content.getBytes("utf-8"));
				out.close();
			} else {
				file=new File(path + Constants.FILE_SEPERATOR + fileName);
				if(!file.exists())  {
					file.createNewFile();
				} else if (!overWrite) {
					//logger.debug(file + " File has exist, abandon！");
					return;
				}
				//logger.debug("Generate file " + file);
				FileOutputStream out=new FileOutputStream(file,false);
				out.write(content.getBytes("utf-8"));
				out.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据数据库字段类型转化为ExtJs类型
	 * @param col
	 * @return
	 */
	public static String getFieldExtJsType(Column col) {
		String extJsType = null;
		if(col.getDataType().equals("NUMBER")||
				col.getDataType().startsWith("BINARY")||
				col.getDataType().startsWith("LONG")) {
			extJsType = "auto";
		} else if (col.getDataType().equals("DATE")||
				col.getDataType().startsWith("TIMESTAMP")) {
			extJsType = "date";
		} else if (col.getDataType().startsWith("CHAR")||
				col.getDataType().startsWith("VARCHAR")||
				col.getDataType().startsWith("NVARCHAR")||
				col.getDataType().indexOf("CLOB")>=0) {
			extJsType = "string";
		} else {
			extJsType = "auto";
		}
		return extJsType;
	}

	/**
	 * 根据数据库字段类型转化为Java类型
	 * @param col
	 * @return
	 */
	public static String getFieldJavaType(Column col) {
		String javaType = null;
		if(col.getDataType().equals("NUMBER")) {
			if (col.getDataScale()!=0) {
				javaType = "Double";
			} else {
				if (col.getDataPrecision()==0 && col.getDataScale()==0) {
					javaType = "BigDecimal";
				} else if (col.getDataPrecision()>18) {
					javaType = "BigDecimal";
				} else if (col.getDataPrecision()>9) {
					javaType = "Long";
				} else {
					javaType = "Integer";
				}
			}
		} else if (col.getDataType().equals("DATE")||
				col.getDataType().startsWith("TIMESTAMP")) {
			javaType = "Date";
		} else if (col.getDataType().equals("BLOB")||
				col.getDataType().startsWith("LONG")) {
			javaType = "byte[]";
		} else if (col.getDataType().equals("BINARY_DOUBLE")) {
			javaType = "Double";
		} else if (col.getDataType().equals("BINARY_FLOAT")) {
			javaType = "Float";
		} else {
			javaType = "String";
		}
		return javaType;
	}

	/**
	 * 根据数据库字段类型转化为Mybatis类型
	 * @param col
	 * @return
	 */
	public static String getFieldMybatisType(Column col) {
		String mybatisType = null;
		if(col.getDataType().equals("NUMBER")||
				col.getDataType().startsWith("BINARY")) {
			mybatisType = "DECIMAL";
		} else if (col.getDataType().equals("DATE")||
				col.getDataType().startsWith("TIMESTAMP")) {
			mybatisType = "TIMESTAMP";
		} else if (col.getDataType().startsWith("CHAR")||
				col.getDataType().startsWith("VARCHAR")||
				col.getDataType().startsWith("NVARCHAR")) {
			mybatisType = "VARCHAR";
		} else if (col.getDataType().startsWith("LONG")) {
			mybatisType = "LONGVARCHAR";
		} else if (col.getDataType().equals("NCLOB")){
			mybatisType = "CLOB";
		} else {
			mybatisType = col.getDataType();
		}
		return mybatisType;
	}

}
