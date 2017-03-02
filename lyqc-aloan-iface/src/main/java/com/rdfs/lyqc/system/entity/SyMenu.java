package com.rdfs.lyqc.system.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单父表
 */

public class SyMenu implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = 2288797108505892172L;
	private String menuId;
    private String menuTitle;
    private String menuIcon;
    private Integer sortNo;
    private List<SyResource> items;
    
    public SyMenu() {
    }

    public String getMenuId() {
        return this.menuId;
    }
    
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuTitle() {
        return this.menuTitle;
    }
    
    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public List<SyResource> getItems() {
		return items;
	}

	public void setItems(List<SyResource> items) {
		this.items = items;
	}

}