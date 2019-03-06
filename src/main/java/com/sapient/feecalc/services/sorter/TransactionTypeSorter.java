package com.sapient.feecalc.services.sorter;

import java.util.Comparator;

import com.sapient.feecalc.services.bean.TransactionBean;

public class TransactionTypeSorter implements Comparator<TransactionBean>{

	@Override
	public int compare(TransactionBean o1, TransactionBean o2) {
		return o1.getTrasactionType().compareTo(o1.getTrasactionType());
	}

}
