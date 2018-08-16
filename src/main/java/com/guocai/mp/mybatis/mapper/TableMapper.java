package com.guocai.mp.mybatis.mapper;

import com.guocai.mp.mybatis.entity.Table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java类简单作用描述
 *
 * @ClassName: TableMapper
 * @Package: TableMapper
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/27 21:05
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public interface TableMapper {

	public List<Table> getTablesByPrefix(Map<String,Object> map);

}
