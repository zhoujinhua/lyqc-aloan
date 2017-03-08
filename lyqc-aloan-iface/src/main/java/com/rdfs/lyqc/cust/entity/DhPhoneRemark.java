package com.rdfs.lyqc.cust.entity;

import java.util.Date;


public class DhPhoneRemark implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String appCode;
	private DhContactPhone phone;
	private String collecStaff;
	private Date remarkTime;
	private String currSion;
	private String phoneRemark;

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

	public String getCollecStaff() {
		return this.collecStaff;
	}

	public void setCollecStaff(String collecStaff) {
		this.collecStaff = collecStaff;
	}

	public Date getRemarkTime() {
		return this.remarkTime;
	}

	public void setRemarkTime(Date remarkTime) {
		this.remarkTime = remarkTime;
	}

	public String getCurrSion() {
		return this.currSion;
	}

	public void setCurrSion(String currSion) {
		this.currSion = currSion;
	}

	public String getPhoneRemark() {
		return this.phoneRemark;
	}

	public void setPhoneRemark(String phoneRemark) {
		this.phoneRemark = phoneRemark;
	}

	public DhContactPhone getPhone() {
		return phone;
	}

	public void setPhone(DhContactPhone phone) {
		this.phone = phone;
	}

}