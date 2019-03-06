package com.sapient.feecalc.services.sorter;

import java.util.Comparator;

import com.sapient.feecalc.services.bean.TransactionBean;

public class TransactionDateSorter implements Comparator<TransactionBean>{

	@Override
	public int compare(TransactionBean o1, TransactionBean o2) {
		// TODO Auto-generated method stub
		return o1.getDate().compareTo(o2.getDate());	
	}

}
