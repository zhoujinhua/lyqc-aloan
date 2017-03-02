package com.rdfs.lyqc.system.entity;


/**
 * 用户部门关系表
 */

public class SyUserDepartment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1605997991269788628L;
	private String userId;
	private String userPostion;
	private Integer departmentId;
	
	private SyDepartment department;

	private String userName;
	private String trueName;
	

	//封装 和数据库没关系  审批流程 查询信贷经理使用
	private String departmentName;
	
	public SyUserDepartment() {
		
	}

	public SyUserDepartment(String userPostion, String departmentName) {
		this.userPostion = userPostion;
		this.departmentName = departmentName;
	}
	
	public SyUserDepartment(String userId) {
		super();
		this.userId = userId;
	}

	public SyUserDepartment(String userId,String userPostion,String userName, String trueName, String departmentName) {
		this.userId = userId;
		this.userPostion = userPostion;
		this.userName = userName;
		this.trueName = trueName;
		this.departmentName = departmentName;
	}

	public String getUserPostion() {
		return this.userPostion;
	}

	public void setUserPostion(String userPostion) {
		this.userPostion = userPostion;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public SyDepartment getDepartment() {
		return department;
	}

	public void setDepartment(SyDepartment department) {
		this.department = department;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	
	

}