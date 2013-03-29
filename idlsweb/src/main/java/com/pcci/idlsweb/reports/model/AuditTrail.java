package com.pcci.idlsweb.reports.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUDIT_TRAIL")
public class AuditTrail {
	@Id
	@Column(name = "ID", nullable = false)
	private String Id;
		
	@Column(name = "USER_ID", nullable = false)
    private String userId;
	
	@Column(name = "AUDIT_DATE", nullable = false)
	private Date date;
	
	@Column(name = "MODULE", nullable = false)
	private String module;
	
	@Column(name = "KEY_VALUE", nullable = false)
	private String keyValue;
	
	@Column(name = "TRANSACTION_TYPE", nullable = false)
	private String transactionType;
	
	@Column(name = "NEW_VALUE", nullable = false)
	private String newValue;
	
	@Column(name = "OLD_VALUE", nullable = false)
	private String oldValue;
	
	@Column(name = "FIELD_NAME", nullable = false)
	private String fieldName;
	
	public AuditTrail() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public String toString() {
		return "AuditTrail [Id=" + Id + ", userId=" + userId + ", date=" + date
				+ ", module=" + module + ", keyValue=" + keyValue
				+ ", transactionType=" + transactionType + ", newValue="
				+ newValue + ", oldValue=" + oldValue + ", fieldName="
				+ fieldName + "]";
	}
	
}
