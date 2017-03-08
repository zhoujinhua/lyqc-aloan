package com.rdfs.lyqc.cust.entity;

import java.util.Date;

public class DhContactPhone implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7018261148542549029L;
	private Integer id;
	private String appCode;
	private String contactType;
	private String relativeType;
	private String phoneNu;
	private String contactName;
	private String phoneStatus;
	private Date remarkTime;
	private String remarkOperator;
	private String dataSource;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAppCode() {
		return this.appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getContactType() {
		return this.contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getRelativeType() {
		return this.relativeType;
	}

	public void setRelativeType(String relativeType) {
		this.relativeType = relativeType;
	}

	public String getPhoneNu() {
		return this.phoneNu;
	}

	public void setPhoneNu(String phoneNu) {
		this.phoneNu = phoneNu;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhoneStatus() {
		return this.phoneStatus;
	}

	public void setPhoneStatus(String phoneStatus) {
		this.phoneStatus = phoneStatus;
	}

	public Date getRemarkTime() {
		return this.remarkTime;
	}

	public void setRemarkTime(Date remarkTime) {
		this.remarkTime = remarkTime;
	}

	public String getRemarkOperator() {
		return this.remarkOperator;
	}

	public void setRemarkOperator(String remarkOperator) {
		this.remarkOperator = remarkOperator;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

}