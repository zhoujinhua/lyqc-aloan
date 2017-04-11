package com.rdfs.lyqc.dianc.entity;

import java.io.Serializable;
import java.util.Date;

import com.rdfs.lyqc.carloan.entity.DmContactInfo;

public class DhCollectionReg implements Serializable{

	/**
	 * 电话催收登记表
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String appCode;
	private DmContactInfo contactInfo;
	private String collStaff;
	private Date remarkTime;
	private String collRemark;
	private Date promisedRepayDate;
	private String weekRemark;
	private String isCollReg;
	private String proceStatus;
	private String collStatus;
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	
	public DmContactInfo getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(DmContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getCollStaff() {
		return collStaff;
	}
	public void setCollStaff(String collStaff) {
		this.collStaff = collStaff;
	}
	public Date getRemarkTime() {
		return remarkTime;
	}
	public void setRemarkTime(Date remarkTime) {
		this.remarkTime = remarkTime;
	}
	public String getCollRemark() {
		return collRemark;
	}
	public void setCollRemark(String collRemark) {
		this.collRemark = collRemark;
	}
	public Date getPromisedRepayDate() {
		return promisedRepayDate;
	}
	public void setPromisedRepayDate(Date promisedRepayDate) {
		this.promisedRepayDate = promisedRepayDate;
	}
	public String getWeekRemark() {
		return weekRemark;
	}
	public void setWeekRemark(String weekRemark) {
		this.weekRemark = weekRemark;
	}
	public String getIsCollReg() {
		return isCollReg;
	}
	public void setIsCollReg(String isCollReg) {
		this.isCollReg = isCollReg;
	}
	public String getProceStatus() {
		return proceStatus;
	}
	public void setProceStatus(String proceStatus) {
		this.proceStatus = proceStatus;
	}
	public String getCollStatus() {
		return collStatus;
	}
	public void setCollStatus(String collStatus) {
		this.collStatus = collStatus;
	}
	
	
	
}
