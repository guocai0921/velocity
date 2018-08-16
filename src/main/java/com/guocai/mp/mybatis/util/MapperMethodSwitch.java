package com.guocai.mp.mybatis.util;

/**
 * java类简单作用描述
 *
 * @ClassName: MapperMethodSwitch
 * @Package: com.guocai.mp.mybatis.util
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/28 21:30
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class MapperMethodSwitch {
	/**
	 * 生成find语句开关
	 */
	private boolean enableFind = true;
	/**
	 * 生成delete语句开关
	 */
	private boolean enableDelete = true;
	/**
	 * 生成deleteByPrimaryKey语句开关
	 */
	private boolean enableDeleteByPrimaryKey = false;
	/**
	 * 生成deleteAll语句开关
	 */
	private boolean enableDeleteAll = false;
	/**
	 * 生成deleteAllByPrimaryKey语句开关
	 */
	private boolean enableDeleteAllByPrimaryKey=false;
	/**
	 * 生成deleteAllByPrimaryKey语句开关
	 */
	private boolean enableInsert = true;
	/**
	 * 生成insertAll语句开关
	 */
	private boolean enableInsertAll = false;
	/**
	 * 生成update语句开关
	 */
	private boolean enableUpdate = true;
	/**
	 * 生成updateAll语句开关
	 */
	private boolean enableUpdateAll = false;
	/**
	 * 生成树形递归查询语句
	 */
	private boolean enableFindTree = false;

	public boolean isEnableFind() {
		return enableFind;
	}
	public void setEnableFind(boolean enableFind) {
		this.enableFind = enableFind;
	}
	public boolean isEnableDelete() {
		return enableDelete;
	}
	public void setEnableDelete(boolean enableDelete) {
		this.enableDelete = enableDelete;
	}
	public boolean isEnableDeleteByPrimaryKey() {
		return enableDeleteByPrimaryKey;
	}
	public void setEnableDeleteByPrimaryKey(boolean enableDeleteByPrimaryKey) {
		this.enableDeleteByPrimaryKey = enableDeleteByPrimaryKey;
	}
	public boolean isEnableDeleteAll() {
		return enableDeleteAll;
	}
	public void setEnableDeleteAll(boolean enableDeleteAll) {
		this.enableDeleteAll = enableDeleteAll;
	}
	public boolean isEnableDeleteAllByPrimaryKey() {
		return enableDeleteAllByPrimaryKey;
	}
	public void setEnableDeleteAllByPrimaryKey(boolean enableDeleteAllByPrimaryKey) {
		this.enableDeleteAllByPrimaryKey = enableDeleteAllByPrimaryKey;
	}
	public boolean isEnableInsert() {
		return enableInsert;
	}
	public void setEnableInsert(boolean enableInsert) {
		this.enableInsert = enableInsert;
	}
	public boolean isEnableInsertAll() {
		return enableInsertAll;
	}
	public void setEnableInsertAll(boolean enableInsertAll) {
		this.enableInsertAll = enableInsertAll;
	}
	public boolean isEnableUpdate() {
		return enableUpdate;
	}
	public void setEnableUpdate(boolean enableUpdate) {
		this.enableUpdate = enableUpdate;
	}
	public boolean isEnableUpdateAll() {
		return enableUpdateAll;
	}
	public void setEnableUpdateAll(boolean enableUpdateAll) {
		this.enableUpdateAll = enableUpdateAll;
	}
	public boolean isEnableFindTree() {
		return enableFindTree;
	}
	public void setEnableFindTree(boolean enableFindTree) {
		this.enableFindTree = enableFindTree;
	}
}
