package com.rdfs.lyqc.dianc.entity;

import java.util.Date;

public class DhOverdueLog implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3089098431209489357L;
	private String tid;
	private String operateUserId;// 操作用户编号
	private String operateUser;// 操作用户名
	private String appCode;// 申请单编号
	private String oldCollUserId;// 原催收员编号
	private String oldCollUser;// 原催收员用户名
	private String newCollUserId;// 新催收员编号
	private String newCollUser;// 新催收员用户名
	private Date createTime;
	private Date updateTime;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getOperateUserId() {
		return operateUserId;
	}

	public void setOperateUserId(String operateUserId) {
		this.operateUserId = operateUserId;
	}

	public String getOperateUser() {
		return operateUser;
	}

	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getOldCollUserId() {
		return oldCollUserId;
	}

	public void setOldCollUserId(String oldCollUserId) {
		this.oldCollUserId = oldCollUserId;
	}

	public String getOldCollUser() {
		return oldCollUser;
	}

	public void setOldCollUser(String oldCollUser) {
		this.oldCollUser = oldCollUser;
	}

	public String getNewCollUserId() {
		return newCollUserId;
	}

	public void setNewCollUserId(String newCollUserId) {
		this.newCollUserId = newCollUserId;
	}

	public String getNewCollUser() {
		return newCollUser;
	}

	public void setNewCollUser(String newCollUser) {
		this.newCollUser = newCollUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}