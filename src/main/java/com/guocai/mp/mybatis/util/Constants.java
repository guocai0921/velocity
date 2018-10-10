package com.guocai.mp.mybatis.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Constants {
	public static String FILE_SEPERATOR =System.getProperty("file.separator");
	public static String TARGET_BASE_PARTH = "d:\\GenerateFile";
	public static String TEMPLATE_PATH = Constants.class.getResource("/").getPath()  + "velocity";
	public static String JAVA_BASE_PATH="java";
	public static String XML_MAPPER_BASE= "resources";
	public static String WEB_APP_BASE="webapp";
	public static String AUTHOR="Sun GuoCai";
	public static String GENERATE_DATE=DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_yyyy_MM_dd_HH_mm_ss);
	public static String VERSION="v1.0.0";
	public static List<String> excludeClumns = new ArrayList<String>(){
		{
			add("sid");
			add("createdBy");
			add("createdTimestamp");
			add("createdDt");
			add("updatedBy");
			add("updatedTimestamp");
			add("updatedDt");
			add("version");
		}
	};
}
