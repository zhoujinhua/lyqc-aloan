package com.rdfs.lyqc.shouc.entity;

import java.util.Date;


public class DhClocarReg implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 595644164589096649L;
	private Integer id;
	private String appCode;
	private String collStaff;
	private Date remarkTime;
	private String collRemark;
	private String requestReason;
	private String requestRemark;
	private String requestStatus;
	private Date updateTime;

	public Integer getId() {
		return this.id;
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

	public String getCollStaff() {
		return this.collStaff;
	}

	public void setCollStaff(String collStaff) {
		this.collStaff = collStaff;
	}

	public Date getRemarkTime() {
		return this.remarkTime;
	}

	public void setRemarkTime(Date remarkTime) {
		this.remarkTime = remarkTime;
	}

	public String getCollRemark() {
		return this.collRemark;
	}

	public void setCollRemark(String collRemark) {
		this.collRemark = collRemark;
	}

	public String getRequestReason() {
		return this.requestReason;
	}

	public void setRequestReason(String requestReason) {
		this.requestReason = requestReason;
	}

	public String getRequestRemark() {
		return this.requestRemark;
	}

	public void setRequestRemark(String requestRemark) {
		this.requestRemark = requestRemark;
	}

	public String getRequestStatus() {
		return this.requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}