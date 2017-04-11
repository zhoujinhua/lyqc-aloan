package com.rdfs.lyqc.division.entity;

import java.io.Serializable;
import java.util.Date;

import com.rdfs.lyqc.system.entity.SyUser;

public class DhDivisionUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8835455825470976511L;
	private Integer id;
	private DhDivisionRule rule;
	private SyUser user;
	private Date beginDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public DhDivisionRule getRule() {
		return rule;
	}
	public void setRule(DhDivisionRule rule) {
		this.rule = rule;
	}
	public SyUser getUser() {
		return user;
	}
	public void setUser(SyUser user) {
		this.user = user;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
}
