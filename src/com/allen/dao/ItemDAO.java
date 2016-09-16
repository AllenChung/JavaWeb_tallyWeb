package com.allen.dao;

import java.util.List;

import com.allen.pojo.showItem;
import com.allen.vo.Item;

public interface ItemDAO {
	/**
	 * ���Ӽ�����Ŀ
	 * @param item
	 * @return ���ӳɹ����
	 * @throws Exception
	 */
	public boolean doAdd(Item item) throws Exception;
	
	/**
	 * ��ѯ���м��˼�¼
	 */
	public List<showItem> findAll(int user_id) throws Exception;
	
	public boolean doDelete(int id) throws Exception;
}
