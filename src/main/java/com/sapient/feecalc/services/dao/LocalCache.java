/**
 * 
 */
package com.sapient.feecalc.services.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sapient.feecalc.services.bean.TransactionBean;
import com.sapient.feecalc.services.utils.Utils;

/**
 * Local database for now
 * 
 * @author utkarsh.thusoo
 *
 */
public class LocalCache {

	private static Map<String,List<TransactionBean>> dao = new HashMap<>();

	/**
	 * @return the dao
	 */
	public static void addData(String id, List<TransactionBean> input) {
		if(dao.containsKey(id)) {
			throw new IllegalArgumentException("ID allready present");
		}
		
		dao.put(id,input);
	}

	/**
	 * @param dao the dao to set
	 */
	public static List<TransactionBean> getData(String id) {
		if(Utils.isEmpty(id)) {
			throw new IllegalArgumentException("ID cannot be null");
		}
		return dao.get(id);
	}
	
	
}
