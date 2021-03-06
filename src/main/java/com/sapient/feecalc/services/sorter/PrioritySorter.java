package com.sapient.feecalc.services.sorter;

import java.util.Comparator;

import com.sapient.feecalc.services.bean.TransactionBean;
import com.sapient.feecalc.services.bean.defs.PriorityType;

public class PrioritySorter  implements Comparator<TransactionBean>{

	@Override
	public int compare(TransactionBean o1, TransactionBean o2) {
		return o1.getPriority() == PriorityType.Y ? 1 : -1;
	}

}
