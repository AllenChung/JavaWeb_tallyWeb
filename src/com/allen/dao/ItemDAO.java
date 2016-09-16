package com.allen.dao;

import java.util.List;

import com.allen.pojo.showItem;
import com.allen.vo.Item;

public interface ItemDAO {
	/**
	 * 增加记账条目
	 * @param item
	 * @return 增加成功与否
	 * @throws Exception
	 */
	public boolean doAdd(Item item) throws Exception;
	
	/**
	 * 查询所有记账记录
	 */
	public List<showItem> findAll(int user_id) throws Exception;
	
	public boolean doDelete(int id) throws Exception;
}
