package com.rdfs.lyqc.cust.entity;


public class DhContactAddr implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3860191499965757381L;
	private Integer id;
	private DhContactPhone phone;
	private String appCode;
	private String contactType;
	private String addr;
	private String addrRemark;
	private String addrValid;
	private String dataSource;

	public String getAddr() {
		return this.addr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DhContactPhone getPhone() {
		return phone;
	}

	public void setPhone(DhContactPhone phone) {
		this.phone = phone;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddrRemark() {
		return this.addrRemark;
	}

	public void setAddrRemark(String addrRemark) {
		this.addrRemark = addrRemark;
	}

	public String getAddrValid() {
		return this.addrValid;
	}

	public void setAddrValid(String addrValid) {
		this.addrValid = addrValid;
	}

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

}