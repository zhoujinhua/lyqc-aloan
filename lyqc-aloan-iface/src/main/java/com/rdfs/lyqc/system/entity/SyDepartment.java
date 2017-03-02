package com.rdfs.lyqc.system.entity;

import java.util.Date;

/**
 * 部门
 */

public class SyDepartment  implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8078490284543302524L;
	private Integer departmentId;
    private String departmentName;
    private SyDepartment parDepartment;
    private String remark;
    private String status;
    private Date crtTime;
    
	public Integer getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SyDepartment getParDepartment() {
		return parDepartment;
	}

	public void setParDepartment(SyDepartment parDepartment) {
		this.parDepartment = parDepartment;
	}

	public Date getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}

    
}