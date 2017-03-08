package com.rdfs.lyqc.carloan.entity;

import java.util.Date;

public class DmCarInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String carId;
	private String carBrand;
	private String carSeries;
	private String carStyles;
	private String carColor;
	private String carMaker;
	private String plateNu;
	private String engineNo;
	private String vehIdentiNu;
	private String gpsSimNu2;
	private String isOld;
	private Double carNewPrice;
	private String gpsSimNu1;
	private String gpsSimNu3;
	private Date updateDate;
	private Integer carMiles;
	private Date carFirstBook;
	private Double ACarPrice;
	private Date exFactoryDate;

	public String getCarId() {
		return this.carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCarBrand() {
		return this.carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarSeries() {
		return this.carSeries;
	}

	public void setCarSeries(String carSeries) {
		this.carSeries = carSeries;
	}

	public String getCarStyles() {
		return this.carStyles;
	}

	public void setCarStyles(String carStyles) {
		this.carStyles = carStyles;
	}

	public String getCarColor() {
		return this.carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCarMaker() {
		return this.carMaker;
	}

	public void setCarMaker(String carMaker) {
		this.carMaker = carMaker;
	}

	public String getPlateNu() {
		return this.plateNu;
	}

	public void setPlateNu(String plateNu) {
		this.plateNu = plateNu;
	}

	public String getEngineNo() {
		return this.engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getVehIdentiNu() {
		return this.vehIdentiNu;
	}

	public void setVehIdentiNu(String vehIdentiNu) {
		this.vehIdentiNu = vehIdentiNu;
	}

	public String getGpsSimNu2() {
		return this.gpsSimNu2;
	}

	public void setGpsSimNu2(String gpsSimNu2) {
		this.gpsSimNu2 = gpsSimNu2;
	}

	public String getIsOld() {
		return this.isOld;
	}

	public void setIsOld(String isOld) {
		this.isOld = isOld;
	}

	public Double getCarNewPrice() {
		return this.carNewPrice;
	}

	public void setCarNewPrice(Double carNewPrice) {
		this.carNewPrice = carNewPrice;
	}

	public String getGpsSimNu1() {
		return this.gpsSimNu1;
	}

	public void setGpsSimNu1(String gpsSimNu1) {
		this.gpsSimNu1 = gpsSimNu1;
	}

	public String getGpsSimNu3() {
		return this.gpsSimNu3;
	}

	public void setGpsSimNu3(String gpsSimNu3) {
		this.gpsSimNu3 = gpsSimNu3;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getCarMiles() {
		return this.carMiles;
	}

	public void setCarMiles(Integer carMiles) {
		this.carMiles = carMiles;
	}

	public Date getCarFirstBook() {
		return this.carFirstBook;
	}

	public void setCarFirstBook(Date carFirstBook) {
		this.carFirstBook = carFirstBook;
	}

	public Double getACarPrice() {
		return this.ACarPrice;
	}

	public void setACarPrice(Double ACarPrice) {
		this.ACarPrice = ACarPrice;
	}

	public Date getExFactoryDate() {
		return this.exFactoryDate;
	}

	public void setExFactoryDate(Date exFactoryDate) {
		this.exFactoryDate = exFactoryDate;
	}

}