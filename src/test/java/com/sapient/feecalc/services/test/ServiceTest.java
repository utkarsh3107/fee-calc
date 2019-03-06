package com.sapient.feecalc.services.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sapient.feecalc.services.CSVExtractor;
import com.sapient.feecalc.services.ReaderWrapper;
import com.sapient.feecalc.services.bean.TransactionBean;
import com.sapient.feecalc.services.extractor.Processor;
import com.sapient.feecalc.services.utils.JsonConverter;

public class ServiceTest {

	private static String resourceName = "data.csv";

	private static ReaderWrapper wrapper = new CSVExtractor();

	private static List<TransactionBean> result = new ArrayList<TransactionBean>();

	@BeforeClass
	public static void init() throws Exception {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream resourceStream = loader.getResourceAsStream(resourceName);
		result = wrapper.getTransactionList(resourceStream);
	}
	
	@Test
	public void testEndToEnd() {
		String id = wrapper.read(resourceName);
		assertNotNull(id);
		List<TransactionBean> report = wrapper.generateReport(id);
		assertNotNull(report);
		assertEquals(20, result.size());
		System.out.println(JsonConverter.toJson(report));
	}

	@Test
	public void testDataLoading() {
		String id = wrapper.read(resourceName);
		assertNotNull(id);
	}

	@Test
	public void testProcessData() {
		Processor.process(result);
		assertNotNull(result);
		assertEquals(20, result.size());
		assertEquals(Long.valueOf(500l), result.get(4).getProcessingValue());
		assertEquals(Long.valueOf(100l), result.get(19).getProcessingValue());
	}

	@Test
	public void testDataExtraction() throws Exception {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream resourceStream = loader.getResourceAsStream(resourceName);
		List<TransactionBean> result = wrapper.getTransactionList(resourceStream);
		assertNotNull(result);
		assertEquals(20, result.size());

	}
}
