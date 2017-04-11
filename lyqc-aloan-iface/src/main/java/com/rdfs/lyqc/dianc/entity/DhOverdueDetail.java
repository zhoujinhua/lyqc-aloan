package com.rdfs.lyqc.dianc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 逾期详情
 * @author zhoufei
 *
 */
public class DhOverdueDetail implements Serializable{
	
	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	private String appCode;
	private Integer overdueDays;
	private Double avgOverdueDays;
	private String overdueRange;
	private Double overdueAmount;
	private Integer overdueInstalls;
	private Integer alreadyInstalls;
	private Integer termFinance;
	private Integer highOverdueDays;
	private Integer sumOverdueDays;
	private Integer exemptionDays;
	private String overdueStatus;
	private String overdueStatusZh;
	private String riskLevel;
	private String fiveClafion;
	private String isCurrOverdue;
	private Integer currVehicleAge;
	private Double usedGuarAmount;
	private Double actSaleRempal;
	private Double curSaleRempal;
	private Double actFinRempal;
	private Double curFinRempal;
	private Double vehAcsdisAmount;
	private Double vehDisposalAmount;
	private String vehRevoveryNotice;
	private String collPhoneStatus;
	private String collPhoneOperator;
	private String collPhoneOperatorName;
	private String litionStatus;
	private String litionOperator;
	private Date litionReqDate;
	private String visitsStatus;
	private String visitsOperator;
	private Date visitsReqDate;
	private String clocarStatus;
	private String clocarOperator;
	private Date clocarReqDate;
	private String vehdisStatus;
	private String vehdisOperator;
	private Date vehdisReqDate;
	private String verifiStatus;
	private String verifiOperator;
	private Date verifiReqDate;
	private Double verifiAmount;
	private String lawyerStatus;
	private String lawyerOperator;
	private Date lawyerReqDate;
	private Date updateDate;
	private Date promisedRepayDate;
	private Date assignDate;
	
	public String getAppCode() {
		return appCode;
	}
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	public Integer getOverdueDays() {
		return overdueDays;
	}
	public void setOverdueDays(Integer overdueDays) {
		this.overdueDays = overdueDays;
	}
	public Double getAvgOverdueDays() {
		return avgOverdueDays;
	}
	public void setAvgOverdueDays(Double avgOverdueDays) {
		this.avgOverdueDays = avgOverdueDays;
	}
	public String getOverdueRange() {
		return overdueRange;
	}
	public void setOverdueRange(String overdueRange) {
		this.overdueRange = overdueRange;
	}
	public Double getOverdueAmount() {
		return overdueAmount;
	}
	public void setOverdueAmount(Double overdueAmount) {
		this.overdueAmount = overdueAmount;
	}
	public Integer getOverdueInstalls() {
		return overdueInstalls;
	}
	public void setOverdueInstalls(Integer overdueInstalls) {
		this.overdueInstalls = overdueInstalls;
	}
	public Integer getAlreadyInstalls() {
		return alreadyInstalls;
	}
	public void setAlreadyInstalls(Integer alreadyInstalls) {
		this.alreadyInstalls = alreadyInstalls;
	}
	public Integer getTermFinance() {
		return termFinance;
	}
	public void setTermFinance(Integer termFinance) {
		this.termFinance = termFinance;
	}
	public Integer getHighOverdueDays() {
		return highOverdueDays;
	}
	public void setHighOverdueDays(Integer highOverdueDays) {
		this.highOverdueDays = highOverdueDays;
	}
	public Integer getSumOverdueDays() {
		return sumOverdueDays;
	}
	public void setSumOverdueDays(Integer sumOverdueDays) {
		this.sumOverdueDays = sumOverdueDays;
	}
	public Integer getExemptionDays() {
		return exemptionDays;
	}
	public void setExemptionDays(Integer exemptionDays) {
		this.exemptionDays = exemptionDays;
	}
	public String getOverdueStatus() {
		return overdueStatus;
	}
	public void setOverdueStatus(String overdueStatus) {
		this.overdueStatus = overdueStatus;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}
	public String getFiveClafion() {
		return fiveClafion;
	}
	public void setFiveClafion(String fiveClafion) {
		this.fiveClafion = fiveClafion;
	}
	public String getIsCurrOverdue() {
		return isCurrOverdue;
	}
	public void setIsCurrOverdue(String isCurrOverdue) {
		this.isCurrOverdue = isCurrOverdue;
	}
	public Integer getCurrVehicleAge() {
		return currVehicleAge;
	}
	public void setCurrVehicleAge(Integer currVehicleAge) {
		this.currVehicleAge = currVehicleAge;
	}
	public Double getUsedGuarAmount() {
		return usedGuarAmount;
	}
	public void setUsedGuarAmount(Double usedGuarAmount) {
		this.usedGuarAmount = usedGuarAmount;
	}
	public Double getActSaleRempal() {
		return actSaleRempal;
	}
	public void setActSaleRempal(Double actSaleRempal) {
		this.actSaleRempal = actSaleRempal;
	}
	public Double getCurSaleRempal() {
		return curSaleRempal;
	}
	public void setCurSaleRempal(Double curSaleRempal) {
		this.curSaleRempal = curSaleRempal;
	}
	public Double getActFinRempal() {
		return actFinRempal;
	}
	public void setActFinRempal(Double actFinRempal) {
		this.actFinRempal = actFinRempal;
	}
	public Double getCurFinRempal() {
		return curFinRempal;
	}
	public void setCurFinRempal(Double curFinRempal) {
		this.curFinRempal = curFinRempal;
	}
	public Double getVehAcsdisAmount() {
		return vehAcsdisAmount;
	}
	public void setVehAcsdisAmount(Double vehAcsdisAmount) {
		this.vehAcsdisAmount = vehAcsdisAmount;
	}
	public Double getVehDisposalAmount() {
		return vehDisposalAmount;
	}
	public void setVehDisposalAmount(Double vehDisposalAmount) {
		this.vehDisposalAmount = vehDisposalAmount;
	}
	public String getVehRevoveryNotice() {
		return vehRevoveryNotice;
	}
	public void setVehRevoveryNotice(String vehRevoveryNotice) {
		this.vehRevoveryNotice = vehRevoveryNotice;
	}
	public String getCollPhoneStatus() {
		return collPhoneStatus;
	}
	public void setCollPhoneStatus(String collPhoneStatus) {
		this.collPhoneStatus = collPhoneStatus;
	}
	public String getLitionStatus() {
		return litionStatus;
	}
	public void setLitionStatus(String litionStatus) {
		this.litionStatus = litionStatus;
	}
	public String getLitionOperator() {
		return litionOperator;
	}
	public void setLitionOperator(String litionOperator) {
		this.litionOperator = litionOperator;
	}
	public Date getLitionReqDate() {
		return litionReqDate;
	}
	public void setLitionReqDate(Date litionReqDate) {
		this.litionReqDate = litionReqDate;
	}
	public String getVisitsStatus() {
		return visitsStatus;
	}
	public void setVisitsStatus(String visitsStatus) {
		this.visitsStatus = visitsStatus;
	}
	public String getVisitsOperator() {
		return visitsOperator;
	}
	public void setVisitsOperator(String visitsOperator) {
		this.visitsOperator = visitsOperator;
	}
	public Date getVisitsReqDate() {
		return visitsReqDate;
	}
	public void setVisitsReqDate(Date visitsReqDate) {
		this.visitsReqDate = visitsReqDate;
	}
	public String getClocarStatus() {
		return clocarStatus;
	}
	public void setClocarStatus(String clocarStatus) {
		this.clocarStatus = clocarStatus;
	}
	public String getClocarOperator() {
		return clocarOperator;
	}
	public void setClocarOperator(String clocarOperator) {
		this.clocarOperator = clocarOperator;
	}
	public Date getClocarReqDate() {
		return clocarReqDate;
	}
	public void setClocarReqDate(Date clocarReqDate) {
		this.clocarReqDate = clocarReqDate;
	}
	public String getVehdisStatus() {
		return vehdisStatus;
	}
	public void setVehdisStatus(String vehdisStatus) {
		this.vehdisStatus = vehdisStatus;
	}
	public Date getVehdisReqDate() {
		return vehdisReqDate;
	}
	public void setVehdisReqDate(Date vehdisReqDate) {
		this.vehdisReqDate = vehdisReqDate;
	}
	public String getVerifiStatus() {
		return verifiStatus;
	}
	public void setVerifiStatus(String verifiStatus) {
		this.verifiStatus = verifiStatus;
	}
	public String getVerifiOperator() {
		return verifiOperator;
	}
	public void setVerifiOperator(String verifiOperator) {
		this.verifiOperator = verifiOperator;
	}
	public Date getVerifiReqDate() {
		return verifiReqDate;
	}
	public void setVerifiReqDate(Date verifiReqDate) {
		this.verifiReqDate = verifiReqDate;
	}
	public Double getVerifiAmount() {
		return verifiAmount;
	}
	public void setVerifiAmount(Double verifiAmount) {
		this.verifiAmount = verifiAmount;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getCollPhoneOperator() {
		return collPhoneOperator;
	}
	public void setCollPhoneOperator(String collPhoneOperator) {
		this.collPhoneOperator = collPhoneOperator;
	}
	public String getCollPhoneOperatorName() {
		return collPhoneOperatorName;
	}
	public void setCollPhoneOperatorName(String collPhoneOperatorName) {
		this.collPhoneOperatorName = collPhoneOperatorName;
	}
	public String getVehdisOperator() {
		return vehdisOperator;
	}
	public void setVehdisOperator(String vehdisOperator) {
		this.vehdisOperator = vehdisOperator;
	}
	public Date getPromisedRepayDate() {
		return promisedRepayDate;
	}
	public void setPromisedRepayDate(Date promisedRepayDate) {
		this.promisedRepayDate = promisedRepayDate;
	}
	public Date getAssignDate() {
		return assignDate;
	}
	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}
	public String getOverdueStatusZh() {
		return overdueStatusZh;
	}
	public void setOverdueStatusZh(String overdueStatusZh) {
		this.overdueStatusZh = overdueStatusZh;
	}
	public String getLawyerStatus() {
		return lawyerStatus;
	}
	public void setLawyerStatus(String lawyerStatus) {
		this.lawyerStatus = lawyerStatus;
	}
	public String getLawyerOperator() {
		return lawyerOperator;
	}
	public void setLawyerOperator(String lawyerOperator) {
		this.lawyerOperator = lawyerOperator;
	}
	public Date getLawyerReqDate() {
		return lawyerReqDate;
	}
	public void setLawyerReqDate(Date lawyerReqDate) {
		this.lawyerReqDate = lawyerReqDate;
	}
	
	

}
