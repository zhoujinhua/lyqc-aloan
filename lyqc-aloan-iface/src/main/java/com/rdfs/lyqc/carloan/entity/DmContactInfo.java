package com.rdfs.lyqc.carloan.entity;

import java.util.Date;

public class DmContactInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appCode;
	private String proppserId;
	private String proppserName;
	private String proppserType;
	private String idType;
	private String idNo;
	private String sex;
	private Integer age;
	private Date birth;
	private String marriage;
	private String censusProvince;
	private String censusCity;
	private String censusAddr;
	private String mobile;
	private String email;
	private String companyName;
	private String companyProvince;
	private String companyCity;
	private String companyPhone;
	private String enterpriseNature;
	private String companyAddr;
	private String companyIndustry;
	private String relativeType;
	private String post;
	private Integer workYeas;
	private Double annualIncome;
	private Double otherIncome;
	private String liveProvince;
	private String liveCity;
	private String liveMobile;
	private String liveAddr;
	private Date updateDate;
	private Date firstWorkTime;
	private Integer nowLivingTime;

	public String getProppserId() {
		return this.proppserId;
	}

	public void setProppserId(String proppserId) {
		this.proppserId = proppserId;
	}

	public String getProppserName() {
		return this.proppserName;
	}

	public void setProppserName(String proppserName) {
		this.proppserName = proppserName;
	}

	public String getProppserType() {
		return this.proppserType;
	}

	public void setProppserType(String proppserType) {
		this.proppserType = proppserType;
	}

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNo() {
		return this.idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	
	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public Integer getAge() {
		if(this.birth!=null){
			return new Date().getYear() - this.birth.getYear();
		}
		return this.age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMarriage() {
		return this.marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getCensusProvince() {
		return this.censusProvince;
	}

	public void setCensusProvince(String censusProvince) {
		this.censusProvince = censusProvince;
	}

	public String getCensusCity() {
		return this.censusCity;
	}

	public void setCensusCity(String censusCity) {
		this.censusCity = censusCity;
	}

	public String getCensusAddr() {
		return this.censusAddr;
	}

	public void setCensusAddr(String censusAddr) {
		this.censusAddr = censusAddr;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyProvince() {
		return this.companyProvince;
	}

	public void setCompanyProvince(String companyProvince) {
		this.companyProvince = companyProvince;
	}

	public String getCompanyCity() {
		return this.companyCity;
	}

	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

	public String getCompanyPhone() {
		return this.companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public String getEnterpriseNature() {
		return this.enterpriseNature;
	}

	public void setEnterpriseNature(String enterpriseNature) {
		this.enterpriseNature = enterpriseNature;
	}

	public String getCompanyAddr() {
		return this.companyAddr;
	}

	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}

	public String getCompanyIndustry() {
		return this.companyIndustry;
	}

	public void setCompanyIndustry(String companyIndustry) {
		this.companyIndustry = companyIndustry;
	}

	public String getRelativeType() {
		return this.relativeType;
	}

	public void setRelativeType(String relativeType) {
		this.relativeType = relativeType;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Integer getWorkYeas() {
		if(this.firstWorkTime!=null){
			return new Date().getYear() - this.firstWorkTime.getYear();
		}
		return this.workYeas;
	}

	public void setWorkYeas(Integer workYeas) {
		this.workYeas = workYeas;
	}

	public Double getAnnualIncome() {
		return this.annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public Double getOtherIncome() {
		return this.otherIncome;
	}

	public void setOtherIncome(Double otherIncome) {
		this.otherIncome = otherIncome;
	}

	public String getLiveProvince() {
		return this.liveProvince;
	}

	public void setLiveProvince(String liveProvince) {
		this.liveProvince = liveProvince;
	}

	public String getLiveCity() {
		return this.liveCity;
	}

	public void setLiveCity(String liveCity) {
		this.liveCity = liveCity;
	}

	public String getLiveMobile() {
		return this.liveMobile;
	}

	public void setLiveMobile(String liveMobile) {
		this.liveMobile = liveMobile;
	}

	public String getLiveAddr() {
		return this.liveAddr;
	}

	public void setLiveAddr(String liveAddr) {
		this.liveAddr = liveAddr;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public Date getFirstWorkTime() {
		return firstWorkTime;
	}

	public void setFirstWorkTime(Date firstWorkTime) {
		this.firstWorkTime = firstWorkTime;
	}

	public Integer getNowLivingTime() {
		return nowLivingTime;
	}

	public void setNowLivingTime(Integer nowLivingTime) {
		this.nowLivingTime = nowLivingTime;
	}
}