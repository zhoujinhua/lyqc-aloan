package com.rdfs.lyqc.division.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DhDivisionRule implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8835455825470976511L;
	private Integer id;
	private String name;
	private String type;
	private String status;
	private String depend;
	private Double min;
	private Double max;
	private String remark;
	private String userId;
	private String userName;
	private Date createTime;
	@JsonIgnore
	private List<DhDivisionUser> divisionUsers;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDepend() {
		return depend;
	}
	public void setDepend(String depend) {
		this.depend = depend;
	}
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<DhDivisionUser> getDivisionUsers() {
		return divisionUsers;
	}
	public void setDivisionUsers(List<DhDivisionUser> divisionUsers) {
		this.divisionUsers = divisionUsers;
	}
	
}
