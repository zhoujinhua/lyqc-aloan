package com.rdfs.lyqc.system.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rdfs.framework.auth.entity.SyPermSet;


/**
 * 
 */

public class SyUser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -879507238085637690L;
	private String userId;
	private String userName;
	private String trueName;
	private String cardType;
	private String cardId;
	private String password;
	private String birthday;
	private String sex;
	private String province;
	private String city;
	private String email;
	private String phone;
	private String address;
	private String postalCode;
	private String head;
	private Date createTime;
	private Date lastTime;
	private Integer loginTimes;
	private String userStatus;
	private String userType;
	
	@JsonIgnore
	private SyUserDepartment userDeparment;
	//验证码
	private String randcode;
	
	@JsonIgnore
	private List<SyPermSet> permSets;
	
	public SyUser() {
		
	}
	
	public SyUser(String userId, String userStatus) {
		super();
		this.userId = userId;
		this.userStatus = userStatus;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTrueName() {
		return this.trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardId() {
		return this.cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getHead() {
		return this.head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	/**
	 * @return the loginTimes
	 */
	public Integer getLoginTimes() {
		return loginTimes;
	}

	/**
	 * @param loginTimes the loginTimes to set
	 */
	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}

	/**
	 * @return the lastTime
	 */
	public Date getLastTime() {
		return lastTime;
	}

	/**
	 * @param lastTime the lastTime to set
	 */
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getRandcode() {
		return randcode;
	}

	public void setRandcode(String randcode) {
		this.randcode = randcode;
	}

	public SyUserDepartment getUserDeparment() {
		return userDeparment;
	}

	public void setUserDeparment(SyUserDepartment userDeparment) {
		this.userDeparment = userDeparment;
	}

	public List<SyPermSet> getPermSets() {
		return permSets;
	}

	public void setPermSets(List<SyPermSet> permSets) {
		this.permSets = permSets;
	}


}