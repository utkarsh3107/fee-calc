/**
 * 
 */
package com.sapient.feecalc.services.extractor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sapient.feecalc.services.bean.TransactionBean;
import com.sapient.feecalc.services.bean.defs.PriorityType;
import com.sapient.feecalc.services.bean.defs.TransactionType;
import com.sapient.feecalc.services.constants.Constants;
import com.sapient.feecalc.services.utils.Utils;

/**
 * @author utkarsh.thusoo
 *
 */
public class Processor {	
	
	public static Logger logger = LogManager.getLogger(Processor.class.getName());
	
	public static void process(List<TransactionBean> input) {
		
		Map<String, Map<TransactionBean, TransactionBean>> processorMap = new HashMap<>();
		
		if(!Utils.isEmpty(input)) {
			for(TransactionBean each  : input) {
				if(!processorMap.containsKey(each.getClientID())) {
					Map<TransactionBean, TransactionBean> temp = new HashMap<>();
					temp.put(each, each);
					processorMap.put(each.getClientID(), temp);
				}else {
					Map<TransactionBean, TransactionBean> value = processorMap.get(each.getClientID());
					//is INTRADAY Transaction
					if(value.containsKey(each)) {
						TransactionBean expectedTransaction = value.get(each);
						switch(expectedTransaction.getTrasactionType()) {
						case BUY:
							if(each.getTrasactionType() == TransactionType.SELL) {
								long processingVal1 = expectedTransaction.getProcessingValue();
								expectedTransaction.setProcessingValue(processingVal1 + Constants.INTARDAY_TRANSACTION_VALUE);
								long processingVal2 = each.getProcessingValue();
								each.setProcessingValue(processingVal2 + Constants.INTARDAY_TRANSACTION_VALUE);								
							}
							break;
						case SELL:
							if(each.getTrasactionType() == TransactionType.BUY) {
								long processingVal1 = expectedTransaction.getProcessingValue();
								expectedTransaction.setProcessingValue(processingVal1 + Constants.INTARDAY_TRANSACTION_VALUE);
								long processingVal2 = each.getProcessingValue();
								each.setProcessingValue(processingVal2 + Constants.INTARDAY_TRANSACTION_VALUE);								
							}
							break;
						default:
							logger.info("Transaction other than BUY/SELL");
							break;
						}
					}else {
						//Normal transaction
						if(each.getPriority() == PriorityType.Y) {
							each.setProcessingValue(Constants.PRIORITY_HIGH + each.getProcessingValue());
						}else {
							if((each.getTrasactionType() == TransactionType.SELL) || (each.getTrasactionType() ==  TransactionType.WITHDRAW)) {
								each.setProcessingValue(Constants.PRIORITY_NORMAL_SELL + each.getProcessingValue());
							}else if((each.getTrasactionType() == TransactionType.BUY) || (each.getTrasactionType() ==  TransactionType.DEPOSIT)) {
								each.setProcessingValue(Constants.PRIORITY_NORMAL_BUY + each.getProcessingValue());
							}
						}
					}
					value.put(each, each);
				}
			}
		}
	}
}
