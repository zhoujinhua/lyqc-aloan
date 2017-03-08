package com.rdfs.lyqc.carloan.entity;

import java.util.Date;

import com.rdfs.lyqc.dianc.entity.DhOverdueDetail;

public class DmAppInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String appCode;
	private DmCarInfo car;
	private Double salePrice;
	private Integer dealerCode;
	private String dealerName;
	private String saleArea;
	private String productName;
	private String debitDate;
	private String debitType;
	private Date loanTime;
	private Double loanAmount;
	private String isGps;
	private Double gpsFee;
	private String appStatus;
	private String finStaff;
	private String repayType;
	private String loanPeriods;
	private String repayFrency;
	private String rateType;
	private String fixedValueType;
	private Double initScale;
	private Double initAmount;
	private Double tailScale;
	private Double tailAmount;
	private String discountType;
	private String discountFixlueType;
	private String feeDebitType;
	private Double feeRate;
	private Double subsidyFee;
	private Double settleFeeRate;
	private Double fee;
	private Double bailProp;
	private Double bailAmount;
	private String bailOffset;
	private Integer bailOffsetPeriods;
	private Double custInterest;
	private Double settlementRate;
	private Double discountAmount;
	private Double eachIssueAmount;
	private String salesAdviser;
	private Double secureFee;
	private Date updateTime;
	private DmContactInfo contactInfo;
	private DhOverdueDetail detail;
	private String am;
	private String inputUserName;//录单人员姓名
	private String inputUserPhone;//录单人员联系电话
	
	public String getAppCode() {
		return this.appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public DmCarInfo getCar() {
		return this.car;
	}

	public void setCar(DmCarInfo car) {
		this.car = car;
	}

	public Double getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getDealerCode() {
		return this.dealerCode;
	}

	public void setDealerCode(Integer dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getDealerName() {
		return this.dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getSaleArea() {
		return this.saleArea;
	}

	public void setSaleArea(String saleArea) {
		this.saleArea = saleArea;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDebitDate() {
		return this.debitDate;
	}

	public void setDebitDate(String debitDate) {
		this.debitDate = debitDate;
	}

	public String getDebitType() {
		return this.debitType;
	}

	public void setDebitType(String debitType) {
		this.debitType = debitType;
	}

	public Date getLoanTime() {
		return this.loanTime;
	}

	public void setLoanTime(Date loanTime) {
		this.loanTime = loanTime;
	}

	public Double getLoanAmount() {
		return this.loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getIsGps() {
		return this.isGps;
	}

	public void setIsGps(String isGps) {
		this.isGps = isGps;
	}

	public Double getGpsFee() {
		return this.gpsFee;
	}

	public void setGpsFee(Double gpsFee) {
		this.gpsFee = gpsFee;
	}

	public String getAppStatus() {
		return this.appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	public String getFinStaff() {
		return this.finStaff;
	}

	public void setFinStaff(String finStaff) {
		this.finStaff = finStaff;
	}

	public String getRepayType() {
		return this.repayType;
	}

	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}

	public String getLoanPeriods() {
		return this.loanPeriods;
	}

	public void setLoanPeriods(String loanPeriods) {
		this.loanPeriods = loanPeriods;
	}

	public String getRepayFrency() {
		return this.repayFrency;
	}

	public void setRepayFrency(String repayFrency) {
		this.repayFrency = repayFrency;
	}

	public String getRateType() {
		return this.rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getFixedValueType() {
		return this.fixedValueType;
	}

	public void setFixedValueType(String fixedValueType) {
		this.fixedValueType = fixedValueType;
	}

	public Double getInitScale() {
		return this.initScale;
	}

	public void setInitScale(Double initScale) {
		this.initScale = initScale;
	}

	public Double getInitAmount() {
		return this.initAmount;
	}

	public void setInitAmount(Double initAmount) {
		this.initAmount = initAmount;
	}

	public Double getTailScale() {
		return this.tailScale;
	}

	public void setTailScale(Double tailScale) {
		this.tailScale = tailScale;
	}

	public Double getTailAmount() {
		return this.tailAmount;
	}

	public void setTailAmount(Double tailAmount) {
		this.tailAmount = tailAmount;
	}

	public String getDiscountType() {
		return this.discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getDiscountFixlueType() {
		return this.discountFixlueType;
	}

	public void setDiscountFixlueType(String discountFixlueType) {
		this.discountFixlueType = discountFixlueType;
	}

	public String getFeeDebitType() {
		return this.feeDebitType;
	}

	public void setFeeDebitType(String feeDebitType) {
		this.feeDebitType = feeDebitType;
	}

	public Double getFeeRate() {
		return this.feeRate;
	}

	public void setFeeRate(Double feeRate) {
		this.feeRate = feeRate;
	}

	public Double getSubsidyFee() {
		return this.subsidyFee;
	}

	public void setSubsidyFee(Double subsidyFee) {
		this.subsidyFee = subsidyFee;
	}

	public Double getSettleFeeRate() {
		return this.settleFeeRate;
	}

	public void setSettleFeeRate(Double settleFeeRate) {
		this.settleFeeRate = settleFeeRate;
	}

	public Double getFee() {
		return this.fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Double getBailProp() {
		return this.bailProp;
	}

	public void setBailProp(Double bailProp) {
		this.bailProp = bailProp;
	}

	public Double getBailAmount() {
		return this.bailAmount;
	}

	public void setBailAmount(Double bailAmount) {
		this.bailAmount = bailAmount;
	}

	public String getBailOffset() {
		return this.bailOffset;
	}

	public void setBailOffset(String bailOffset) {
		this.bailOffset = bailOffset;
	}

	public Integer getBailOffsetPeriods() {
		return this.bailOffsetPeriods;
	}

	public void setBailOffsetPeriods(Integer bailOffsetPeriods) {
		this.bailOffsetPeriods = bailOffsetPeriods;
	}

	public Double getCustInterest() {
		return this.custInterest;
	}

	public void setCustInterest(Double custInterest) {
		this.custInterest = custInterest;
	}

	public Double getSettlementRate() {
		return this.settlementRate;
	}

	public void setSettlementRate(Double settlementRate) {
		this.settlementRate = settlementRate;
	}

	public Double getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(Double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Double getEachIssueAmount() {
		return this.eachIssueAmount;
	}

	public void setEachIssueAmount(Double eachIssueAmount) {
		this.eachIssueAmount = eachIssueAmount;
	}

	public String getSalesAdviser() {
		return this.salesAdviser;
	}

	public void setSalesAdviser(String salesAdviser) {
		this.salesAdviser = salesAdviser;
	}

	public Double getSecureFee() {
		return this.secureFee;
	}

	public void setSecureFee(Double secureFee) {
		this.secureFee = secureFee;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public DmContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(DmContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public DhOverdueDetail getDetail() {
		return detail;
	}

	public void setDetail(DhOverdueDetail detail) {
		this.detail = detail;
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public String getInputUserName() {
		return inputUserName;
	}

	public void setInputUserName(String inputUserName) {
		this.inputUserName = inputUserName;
	}

	public String getInputUserPhone() {
		return inputUserPhone;
	}

	public void setInputUserPhone(String inputUserPhone) {
		this.inputUserPhone = inputUserPhone;
	}

}