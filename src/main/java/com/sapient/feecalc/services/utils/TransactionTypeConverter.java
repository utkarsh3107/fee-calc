/**
 * 
 */
package com.sapient.feecalc.services.utils;

import com.sapient.feecalc.services.bean.defs.TransactionType;

import net.sf.jsefa.common.converter.SimpleTypeConverter;

/**
 * @author 
 *
 */
public class TransactionTypeConverter  implements SimpleTypeConverter{

	private static final TransactionTypeConverter INSTANCE = new TransactionTypeConverter();

	public static TransactionTypeConverter create() {
		return INSTANCE;
	}

	private TransactionTypeConverter() {
	}
	
	@Override
	public String toString(Object value) {
		if (!Utils.isEmpty(value)) {
			System.out.println("I am here 2");
			return TransactionType.valueOf(value.toString()).name();
		} else {
			return null;
		}
	}

	@Override
	public Object fromString(String value) {
		if (!Utils.isEmpty(value)) {
			return TransactionType.valueOf(value);
		} else {
			return null;
		}
	}

}
