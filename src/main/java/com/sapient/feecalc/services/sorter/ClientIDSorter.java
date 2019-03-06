/**
 * 
 */
package com.sapient.feecalc.services.sorter;

import java.util.Comparator;

import com.sapient.feecalc.services.bean.TransactionBean;
import com.sapient.feecalc.services.bean.defs.PriorityType;

/**
 * @author utkarsh.thusoo
 *
 */
public class ClientIDSorter implements Comparator<TransactionBean> {

	@Override
	public int compare(TransactionBean arg0, TransactionBean arg1) {

		return arg0.getClientID().compareTo(arg1.getClientID());
	}

}
