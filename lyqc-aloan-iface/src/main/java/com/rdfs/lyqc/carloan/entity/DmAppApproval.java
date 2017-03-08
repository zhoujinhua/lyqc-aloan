package com.rdfs.lyqc.carloan.entity;

import java.util.Date;

public class DmAppApproval implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3014083645786780300L;
	private Integer carId;
	private String appCode;
	private Integer userId;
	private String userName;
	private String status;
	private Short flowNo;
	private String flowName;
	private String type;
	private String remarks;
	private Date approvalTime;

	public Integer getCarId() {
		return this.carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getAppCode() {
		return this.appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Short getFlowNo() {
		return this.flowNo;
	}

	public void setFlowNo(Short flowNo) {
		this.flowNo = flowNo;
	}

	public String getFlowName() {
		return this.flowName;
	}

	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getApprovalTime() {
		return this.approvalTime;
	}

	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}

}