package com.rdfs.lyqc.common.dto;

import java.io.Serializable;

public class TreeDto implements Serializable{

	/**
	 * 树节点封装
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;  
    private String pId;  
    private String name;  
    private boolean open;
    private boolean checked;
    
    
	public TreeDto() {
		super();
	}
	public TreeDto(String id, String pId, String name, boolean open, boolean checked) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.checked = checked;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
    
    
}
