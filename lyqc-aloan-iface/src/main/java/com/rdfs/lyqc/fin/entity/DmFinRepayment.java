package com.rdfs.lyqc.fin.entity;

import java.util.Date;

public class DmFinRepayment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3964627991813672258L;
	private Long id;
	private String appNo;
	private String repaymentCard;
	private String repaymentCardNumber;
	private Integer FYear;
	private Integer FMonth;
	private Integer FDay;
	private Date paymentDate;
	private Double principal;
	private Double interest;
	private Double repayment;
	private Double fine;
	private Double feeOth;
	private Double freeFee;
	private Double totleRepayment;
	private Date factPaymentDate;
	private Double factRepayment;
	private String status;
	private Date updateDate;
	private Integer repayNu;
	private Double spentAmount;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppNo() {
		return this.appNo;
	}

	public void setAppNo(String appNo) {
		this.appNo = appNo;
	}

	public String getRepaymentCard() {
		return this.repaymentCard;
	}

	public void setRepaymentCard(String repaymentCard) {
		this.repaymentCard = repaymentCard;
	}

	public String getRepaymentCardNumber() {
		return this.repaymentCardNumber;
	}

	public void setRepaymentCardNumber(String repaymentCardNumber) {
		this.repaymentCardNumber = repaymentCardNumber;
	}

	public Integer getFYear() {
		return this.FYear;
	}

	public void setFYear(Integer FYear) {
		this.FYear = FYear;
	}

	public Integer getFMonth() {
		return this.FMonth;
	}

	public void setFMonth(Integer FMonth) {
		this.FMonth = FMonth;
	}

	public Integer getFDay() {
		return this.FDay;
	}

	public void setFDay(Integer FDay) {
		this.FDay = FDay;
	}

	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Double getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getInterest() {
		return this.interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public Double getRepayment() {
		return this.repayment;
	}

	public void setRepayment(Double repayment) {
		this.repayment = repayment;
	}

	public Double getFine() {
		return this.fine;
	}

	public void setFine(Double fine) {
		this.fine = fine;
	}

	public Double getFeeOth() {
		return this.feeOth;
	}

	public void setFeeOth(Double feeOth) {
		this.feeOth = feeOth;
	}

	public Double getFreeFee() {
		return this.freeFee;
	}

	public void setFreeFee(Double freeFee) {
		this.freeFee = freeFee;
	}

	public Double getTotleRepayment() {
		return this.totleRepayment;
	}

	public void setTotleRepayment(Double totleRepayment) {
		this.totleRepayment = totleRepayment;
	}

	public Date getFactPaymentDate() {
		return this.factPaymentDate;
	}

	public void setFactPaymentDate(Date factPaymentDate) {
		this.factPaymentDate = factPaymentDate;
	}

	public Double getFactRepayment() {
		return this.factRepayment;
	}

	public void setFactRepayment(Double factRepayment) {
		this.factRepayment = factRepayment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getRepayNu() {
		return this.repayNu;
	}

	public void setRepayNu(Integer repayNu) {
		this.repayNu = repayNu;
	}

	public Double getSpentAmount() {
		return spentAmount;
	}

	public void setSpentAmount(Double spentAmount) {
		this.spentAmount = spentAmount;
	}

}