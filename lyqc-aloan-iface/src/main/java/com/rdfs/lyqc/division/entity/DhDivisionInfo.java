package com.rdfs.lyqc.division.entity;

import java.io.Serializable;
import java.util.Date;

public class DhDivisionInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3172869025127261010L;
	private Integer id;
	private String userId;
	private String userName;
	private Date currDate;
	private Integer count;
	private Integer inNu;
	private Integer outNu;
	private String remark;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getCurrDate() {
		return currDate;
	}
	public void setCurrDate(Date currDate) {
		this.currDate = currDate;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getInNu() {
		return inNu;
	}
	public void setInNu(Integer inNu) {
		this.inNu = inNu;
	}
	public Integer getOutNu() {
		return outNu;
	}
	public void setOutNu(Integer outNu) {
		this.outNu = outNu;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
