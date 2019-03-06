/**
 * 
 */
package com.sapient.feecalc.services.utils;

import com.sapient.feecalc.services.bean.defs.PriorityType;
import com.sapient.feecalc.services.bean.defs.TransactionType;

import net.sf.jsefa.common.converter.SimpleTypeConverter;

/**
 * @author 
 *
 */
public class PriorityConverter implements SimpleTypeConverter{

	private static final PriorityConverter INSTANCE = new PriorityConverter();

	public static PriorityConverter create() {
		return INSTANCE;
	}

	private PriorityConverter() {
	}
	
	@Override
	public String toString(Object value) {
		if (!Utils.isEmpty(value)) {
			System.out.println("I am here");
			return PriorityType.valueOf(value.toString()).name();
		} else {
			return null;
		}
	}

	@Override
	public Object fromString(String value) {
		if (!Utils.isEmpty(value)) {
			return PriorityType.valueOf(value);
		} else {
			return null;
		}
	}

}
