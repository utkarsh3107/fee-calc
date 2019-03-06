package com.sapient.feecalc.services;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.sapient.feecalc.services.bean.TransactionBean;

/**
 * For Future Implementation
 * 
 * @author utkarsh.thusoo
 *
 */
public class XMLExtractor implements ReaderWrapper{

	@Override
	public String read(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String read(String filePath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionBean> getTransactionList(InputStream stream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransactionBean> generateReport(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
