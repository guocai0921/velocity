package com.guocai.mp.mybatis.entity;

import com.guocai.mp.mybatis.util.Constants;
import com.guocai.mp.mybatis.util.GeneratorUtil;
import com.guocai.mp.mybatis.util.Util;

/**
 * java类简单作用描述
 *
 * @ClassName: Column
 * @Package: com.guocai.mp.mybatis.entity
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/27 21:18
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class Column {
	/**
	 * 数据库字段名称
	 */
	private String columnName;
	/**
	 * 数据库字段类型
	 */
	private String dataType;
	/**
	 * 数据库字段描述
	 */
	private String columnDesc="[Column Comment not set]";
	/**
	 * 数据库字段定义的长度
	 */
	private int dataPrecision;
	/**
	 * 数据库字段定义的小数位数
	 */
	private int dataScale;
	/**
	 * 是否可为空
	 */
	private String nullFlag;


	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getColumnDesc() {
		return columnDesc;
	}

	public void setColumnDesc(String columnDesc) {
		this.columnDesc = columnDesc;
	}

	public int getDataPrecision() {
		return dataPrecision;
	}

	public void setDataPrecision(int dataPrecision) {
		this.dataPrecision = dataPrecision;
	}

	public int getDataScale() {
		return dataScale;
	}

	public void setDataScale(int dataScale) {
		this.dataScale = dataScale;
	}

	public String getNullFlag() {
		return nullFlag;
	}

	public void setNullFlag(String nullFlag) {
		this.nullFlag = nullFlag;
	}

	/**
	 * 返回字段名称
	 * @return
	 */
	public String getFieldName () {
		return Util.underlineToCamel(this.columnName);
	}

	/**
	 * 判断字段是否在排除字段集之内(抽象类中包含的字段排除在生成的Entity属性之外)
	 * @return
	 */
	public boolean isExcludeFiled() {
		boolean isExcludeField=false;
		if (Constants.excludeClumns.contains(this.getFieldName())) {
			isExcludeField =true;
		}
		return isExcludeField;
	}
	/**
	 * 返回字段对应的Java数据类型
	 * @return
	 */
	public String getFieldJavaType() {
		return GeneratorUtil.getFieldJavaType(this);
	}
	/**
	 * 返回字段对应的ExtJs数据类型
	 * @return
	 */
	public String getFieldExtJsType() {
		return GeneratorUtil.getFieldExtJsType(this);
	}
	/**
	 * 返回首字母大写的字段名称
	 * @return
	 */
	public String getFirstLetterUpperFieldName() {
		return Util.firstLetterToUpper(this.getFieldName());
	}

	/**
	 * 判断字段是否LOB or LONG类型
	 * @return
	 */
	public boolean isBigColumn() {
		boolean isBigColumn = false;
		if (this.getDataType().indexOf("LOB")>=0 ||
				this.getDataType().startsWith("LONG")) {
			isBigColumn = true;
		}
		return isBigColumn;
	}
	/**
	 * 返回该字段对应的Mybatis数据类型
	 * @return
	 */
	public String getFieldMybatisType() {
		return GeneratorUtil.getFieldMybatisType(this);
	}
	/**
	 * 字段是否可为空
	 * @return
	 */
	public boolean isNullable() {
		if (this.getNullFlag().equals("Y")) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		StringBuffer sb =new StringBuffer();
		sb.append("ColumnName:" + this.columnName + ", DataType:" + this.dataType + ", Comment:" + this.columnDesc + ", dataPrecesion:" + this.dataPrecision + ", dataScale:" + this.dataScale);
		return sb.toString();
	}
}
