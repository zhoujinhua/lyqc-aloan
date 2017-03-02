package com.rdfs.lyqc.system.entity;


/**
 * 菜单项
 */

public class SyResource  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3392015057148573094L;
	private String itemId;
	private String itemTitle;
	private String itemLocation;
	private String menuId;
	private String itemIcon;
	private Integer sortNo;

    /** default constructor */
    public SyResource() {
    }

    public String getItemId() {
        return this.itemId;
    }
    
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemTitle() {
        return this.itemTitle;
    }
    
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemLocation() {
        return this.itemLocation;
    }
    
    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getMenuId() {
        return this.menuId;
    }
    
    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public String getItemIcon() {
        return this.itemIcon;
    }
    
    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }
}