/**
 * 
 */
package com.sapient.feecalc.services.bean;

import java.util.Date;

import com.sapient.feecalc.services.bean.defs.PriorityType;
import com.sapient.feecalc.services.bean.defs.TransactionType;

import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

/**
 * @author utkarsh.thusoo
 *
 */
@CsvDataType()
public class TransactionBean {

	private String attrName;

	@CsvField(pos = 1)
	private String transactionID;

	@CsvField(pos = 2)
	private String clientID;

	@CsvField(pos = 3)
	private String securityID;

	@CsvField(pos = 4)
	private TransactionType trasactionType;

	@CsvField(pos = 5, format = "dd-MM-yyyy")
	private Date date;

	@CsvField(pos = 6)
	private Double value;

	@CsvField(pos = 7)
	private PriorityType priority;
	
	private Long processingValue;
	
	public TransactionBean() {
		this.processingValue = 0L;
	}

	/**
	 * @return the processingValue
	 */
	public Long getProcessingValue() {
		return processingValue;
	}

	/**
	 * @param processingValue the processingValue to set
	 */
	public void setProcessingValue(Long processingValue) {
		this.processingValue = processingValue;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getSecurityID() {
		return securityID;
	}

	public void setSecurityID(String securityID) {
		this.securityID = securityID;
	}

	public TransactionType getTrasactionType() {
		return trasactionType;
	}

	public void setTrasactionType(TransactionType trasactionType) {
		this.trasactionType = trasactionType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public PriorityType getPriority() {
		return priority;
	}

	public void setPriority(PriorityType priority) {
		this.priority = priority;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientID == null) ? 0 : clientID.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((securityID == null) ? 0 : securityID.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionBean other = (TransactionBean) obj;
		if (clientID == null) {
			if (other.clientID != null)
				return false;
		} else if (!clientID.equals(other.clientID))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (securityID == null) {
			if (other.securityID != null)
				return false;
		} else if (!securityID.equals(other.securityID))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionBean [attrName=" + attrName + ", transactionID=" + transactionID + ", clientID=" + clientID
				+ ", securityID=" + securityID + ", trasactionType=" + trasactionType + ", date=" + date + ", value="
				+ value + ", priority=" + priority + ", processingValue=" + processingValue + "]";
	}
	
	
	
}
