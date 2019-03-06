/**
 * 
 */
package com.sapient.feecalc.services;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.sapient.feecalc.services.bean.TransactionBean;

/**
 * The Wrapper method for all the readers
 * 
 * @author utkarsh.thusoo
 *
 */
public interface ReaderWrapper {

	/**
	 * User can pass a file directly to this method. This will read the file and
	 * process it.
	 * 
	 * @param file
	 * @return String - Unique ID which can be later used to get the report at any
	 *         time.
	 */
	String read(File file);

	/**
	 * User can pass a filepath directly to this method. This will read the file and
	 * process it.
	 * 
	 * @param file
	 * @return String - Unique ID which can be later used to get the report at any
	 *         time.
	 */
	String read(String filePath);

	/**
	 * Converts stream to List of Transaction Beans
	 * 
	 * @param stream
	 * @return List<TransactionBean>
	 */
	List<TransactionBean> getTransactionList(InputStream stream);

	/**
	 * Generates the report for the id provided
	 * 
	 * @param id
	 * @return
	 */
	List<TransactionBean> generateReport(String id);
}
