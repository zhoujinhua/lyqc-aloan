package com.rdfs.lyqc.system.entity;

import com.rdfs.lyqc.dealer.entity.SyDealer;

/**
 * 用户和经销商关联关系表
 */

public class SyUserDealer implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7628309667737099973L;
	private Integer id;
	private SyDealer dealer;
	private SyUser user;
	private String userPostion;
	
	public SyUserDealer() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	/*public Integer getDealerCode() {
		return dealerCode;
	}


	public void setDealerCode(Integer dealerCode) {
		this.dealerCode = dealerCode;
	}*/
	
	


	public SyUser getUser() {
		return user;
	}


	public SyDealer getDealer() {
		return dealer;
	}


	public void setDealer(SyDealer dealer) {
		this.dealer = dealer;
	}


	public void setUser(SyUser user) {
		this.user = user;
	}


	public String getUserPostion() {
		return this.userPostion;
	}

	public void setUserPostion(String userPostion) {
		this.userPostion = userPostion;
	}

}