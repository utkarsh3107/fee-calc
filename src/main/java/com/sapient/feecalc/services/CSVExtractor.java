/**
 * 
 */
package com.sapient.feecalc.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sapient.feecalc.services.bean.TransactionBean;
import com.sapient.feecalc.services.bean.defs.PriorityType;
import com.sapient.feecalc.services.bean.defs.TransactionType;
import com.sapient.feecalc.services.dao.LocalCache;
import com.sapient.feecalc.services.extractor.Processor;
import com.sapient.feecalc.services.sorter.ClientIDSorter;
import com.sapient.feecalc.services.sorter.PrioritySorter;
import com.sapient.feecalc.services.sorter.TransactionDateSorter;
import com.sapient.feecalc.services.sorter.TransactionTypeSorter;
import com.sapient.feecalc.services.utils.DoubleConverter;
import com.sapient.feecalc.services.utils.PriorityConverter;
import com.sapient.feecalc.services.utils.TransactionTypeConverter;

import net.sf.jsefa.Deserializer;
import net.sf.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import net.sf.jsefa.csv.CsvIOFactory;
import net.sf.jsefa.csv.config.CsvConfiguration;

/**
 * @author utkarsh.thusoo
 *
 */
public class CSVExtractor implements ReaderWrapper {

	public static Logger logger = LogManager.getLogger(CSVExtractor.class.getName());

	@Override
	public String read(File file) {
		logger.info("Initialted read with File provided {}", file);
		String uniqueID = UUID.randomUUID().toString();
		try {

			InputStream targetStream = new FileInputStream(file);
			List<TransactionBean> beanList = getTransactionList(targetStream);
			Processor.process(beanList);
			Collections.sort(beanList, new ClientIDSorter().thenComparing(new TransactionTypeSorter())
					.thenComparing(new TransactionDateSorter()).thenComparing(new PrioritySorter()));
			
			LocalCache.addData(uniqueID, beanList);

		} catch (IOException ex) {
			logger.error("Parsing exceptiion @ read File {}", ex);
		}
		logger.info("Finished read with File provided {}", file);
		return uniqueID;
	}

	@Override
	public String read(String filePath) {
		logger.info("Initialted read with filePath provided {}", filePath);
		String uniqueID = UUID.randomUUID().toString();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream resourceStream = loader.getResourceAsStream(filePath);
			List<TransactionBean> beanList = getTransactionList(resourceStream);
			Processor.process(beanList);
			
			Collections.sort(beanList, new ClientIDSorter().thenComparing(new TransactionTypeSorter())
					.thenComparing(new TransactionDateSorter()).thenComparing(new PrioritySorter()));
			
			LocalCache.addData(uniqueID, beanList);
		} catch (Exception ex) {
			logger.error("Exceptiion @ read filePath {}", ex);
		}

		logger.info("Finished read with filePath provided {}", filePath);
		return uniqueID;
	}

	@Override
	public List<TransactionBean> getTransactionList(InputStream stream) {
		CsvConfiguration config = new CsvConfiguration();
		config.setFieldDelimiter(',');
		config.setLineFilter(new HeaderAndFooterFilter(1, false, false));
		config.getSimpleTypeConverterProvider().registerConverterType(Double.class, DoubleConverter.class);
		config.getSimpleTypeConverterProvider().registerConverterType(TransactionType.class,
				TransactionTypeConverter.class);
		config.getSimpleTypeConverterProvider().registerConverterType(PriorityType.class, PriorityConverter.class);
		Deserializer deserializer = CsvIOFactory.createFactory(config, TransactionBean.class).createDeserializer();

		List<TransactionBean> result = new ArrayList<TransactionBean>();

		deserializer.open(new InputStreamReader(stream));

		while (deserializer.hasNext()) {
			result.add(deserializer.<TransactionBean>next());
		}

		deserializer.close(true);

		return result;

	}

	@Override
	public List<TransactionBean> generateReport(String id) {
		return LocalCache.getData(id);
	}
}
