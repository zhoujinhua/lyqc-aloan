package com.rdfs.lyqc.carloan.entity;

import java.util.Date;

public class DmBfLoanFee implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3044281870356872313L;
	private String appCode;
	private String feeType;
	private Double feeAmount;
	private String feeBigType;
	private Date payDate;
	private String payStatus;
	private Date updateDate;

	public Double getFeeAmount() {
		return this.feeAmount;
	}

	public String getAppCode() {
		return appCode;
	}


	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}


	public String getFeeType() {
		return feeType;
	}


	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}


	public void setFeeAmount(Double feeAmount) {
		this.feeAmount = feeAmount;
	}

	public String getFeeBigType() {
		return this.feeBigType;
	}

	public void setFeeBigType(String feeBigType) {
		this.feeBigType = feeBigType;
	}

	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public String getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}