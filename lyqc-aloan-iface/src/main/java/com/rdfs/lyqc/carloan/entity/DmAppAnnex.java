package com.rdfs.lyqc.carloan.entity;

import java.util.Date;

public class DmAppAnnex implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7780494413146099960L;
	private Integer annexId;
	private String appCode;
	private String annexName;
	private String annexType;
	private String annexAddress;
	private Date createTime;
	private Integer userId;
	private String userName;
	private Short status;
	private String remarks;
	private Date updateDate;

	public Integer getAnnexId() {
		return this.annexId;
	}

	public void setAnnexId(Integer annexId) {
		this.annexId = annexId;
	}

	public String getAppCode() {
		return this.appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAnnexName() {
		return this.annexName;
	}

	public void setAnnexName(String annexName) {
		this.annexName = annexName;
	}

	public String getAnnexType() {
		return this.annexType;
	}

	public void setAnnexType(String annexType) {
		this.annexType = annexType;
	}

	public String getAnnexAddress() {
		return this.annexAddress;
	}

	public void setAnnexAddress(String annexAddress) {
		this.annexAddress = annexAddress;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}