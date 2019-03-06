/**
 * 
 */
package com.sapient.feecalc.services.utils;

import net.sf.jsefa.common.converter.SimpleTypeConverter;

/**
 * @author utkarsh.thusoo
 *
 */
public class DoubleConverter implements SimpleTypeConverter {

	private static final DoubleConverter INSTANCE = new DoubleConverter();

	public static DoubleConverter create() {
		return INSTANCE;
	}

	private DoubleConverter() {
	}

	@Override
	public Object fromString(String s) {
		if (!Utils.isEmpty(s)) {
			return new Double(s);
		} else {
			return null;
		}
	}

	@Override
	public String toString(Object d) {
		if (!Utils.isEmpty(d)) {
			return d.toString();
		} else {
			return null;
		}
	}

}