package com.rdfs.lyqc.dealer.entity;

import java.util.Date;

/**
 * 经销商单位信息
 */

public class SyDealerCompany implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4592162733341743873L;
	private Integer companyCode;
	private String companyName;
	private String companyType;
	private String province;
	private String city;
	private String saleArea;
	private String address;
	private String brandType;
	private String brandName;
	private String dealerEmail;
	private String contactPerson;
	private String accountName;
	private String tel;
	private String appNo;
	private String isVip;
	private Date onlineTime;
	private Date updateTime;
	private String status;
	private String remarks;

	private String accountIdno;
	private String accountBank;
	private String accountSubBank;
	private String bankProvince;
	private String bankCity;
	private String accountNo;
	private String accountType;

	public SyDealerCompany() {
		
	}

	public Integer getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyType() {
		return this.companyType;
	}
	
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSaleArea() {
		return this.saleArea;
	}

	public void setSaleArea(String saleArea) {
		this.saleArea = saleArea;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBrandType() {
		return this.brandType;
	}

	public void setBrandType(String brandType) {
		this.brandType = brandType;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getDealerEmail() {
		return this.dealerEmail;
	}

	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAppNo() {
		return this.appNo;
	}

	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}

	public String getIsVip() {
		return this.isVip;
	}

	public void setIsVip(String isVip) {
		this.isVip = isVip;
	}

	public Date getOnlineTime() {
		return this.onlineTime;
	}

	public void setOnlineTime(Date onlineTime) {
		this.onlineTime = onlineTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAccountIdno() {
		return accountIdno;
	}

	public void setAccountIdno(String accountIdno) {
		this.accountIdno = accountIdno;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	public String getAccountSubBank() {
		return accountSubBank;
	}

	public void setAccountSubBank(String accountSubBank) {
		this.accountSubBank = accountSubBank;
	}

	public String getBankProvince() {
		return bankProvince;
	}

	public void setBankProvince(String bankProvince) {
		this.bankProvince = bankProvince;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}