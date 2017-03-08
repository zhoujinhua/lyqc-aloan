/*
 * DmDealerInfo.java
 * Copyright(C) 20xx-20xx 力蕴汽车咨询服务（上海）有限公司
 * All right reserved.
 * --------------------------
 * 2017-01-04 15:15 Created
 */
package com.rdfs.lyqc.carloan.entity;

import java.util.Date;

/**
 * 经销商信息
 *
 * @author zhaozhaoxin
 * @version 1.0
 * @date 2017-01-04 15:15
 *
 */
public class DmDealerInfo {
    /**
     * 
     */
    private Integer dealerCode;

    /**
     * 
     */
    private String dealerName;

    /**
     * 目前分两类：DD、 SP
     */
    private String dealerType;

    /**
     * 
     */
    private Integer companyCode;

    /**
     * 
     */
    private String recAccountName;

    /**
     * 
     */
    private String recAccountCard;

    /**
     * 
     */
    private String recAccountBank;

    /**
     * 
     */
    private String recAccountBank2;

    /**
     * 
     */
    private String bankProvince;

    /**
     * 
     */
    private String bankCity;

    /**
     * 
     */
    private String recAccountNo;

    /**
     * 
     */
    private String province;

    /**
     * 
     */
    private String city;

    /**
     * 
     */
    private String saleArea;

    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String rtamil;

    /**
     * 
     */
    private String am;

    /**
     * 
     */
    private String amMobile;

    /**
     * 域状态 1-有效, 0-无效
     */
    private String status;

    /**
     * 
     */
    private Date onlineTime;

    /**
     * 1 对公,2 对私
     */
    private String accountType;

    public Integer getDealerCode() {
        return dealerCode;
    }

    public void setDealerCode(Integer dealerCode) {
        this.dealerCode = dealerCode;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName == null ? null : dealerName.trim();
    }

    public String getDealerType() {
        return dealerType;
    }

    public void setDealerType(String dealerType) {
        this.dealerType = dealerType == null ? null : dealerType.trim();
    }

    public Integer getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Integer companyCode) {
        this.companyCode = companyCode;
    }

    public String getRecAccountName() {
        return recAccountName;
    }

    public void setRecAccountName(String recAccountName) {
        this.recAccountName = recAccountName == null ? null : recAccountName.trim();
    }

    public String getRecAccountCard() {
        return recAccountCard;
    }

    public void setRecAccountCard(String recAccountCard) {
        this.recAccountCard = recAccountCard == null ? null : recAccountCard.trim();
    }

    public String getRecAccountBank() {
        return recAccountBank;
    }

    public void setRecAccountBank(String recAccountBank) {
        this.recAccountBank = recAccountBank == null ? null : recAccountBank.trim();
    }

    public String getRecAccountBank2() {
        return recAccountBank2;
    }

    public void setRecAccountBank2(String recAccountBank2) {
        this.recAccountBank2 = recAccountBank2 == null ? null : recAccountBank2.trim();
    }

    public String getBankProvince() {
        return bankProvince;
    }

    public void setBankProvince(String bankProvince) {
        this.bankProvince = bankProvince == null ? null : bankProvince.trim();
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity == null ? null : bankCity.trim();
    }

    public String getRecAccountNo() {
        return recAccountNo;
    }

    public void setRecAccountNo(String recAccountNo) {
        this.recAccountNo = recAccountNo == null ? null : recAccountNo.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getSaleArea() {
        return saleArea;
    }

    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea == null ? null : saleArea.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getRtamil() {
        return rtamil;
    }

    public void setRtamil(String rtamil) {
        this.rtamil = rtamil == null ? null : rtamil.trim();
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am == null ? null : am.trim();
    }

    public String getAmMobile() {
        return amMobile;
    }

    public void setAmMobile(String amMobile) {
        this.amMobile = amMobile == null ? null : amMobile.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Date onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType == null ? null : accountType.trim();
    }
}