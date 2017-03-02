package com.rdfs.lyqc.system.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * 公告
 *
 */
public class SyAnnouncement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5777963215769433822L;
	private Integer id;
	private String headline;
	private String content;
	private String isPublish;
	private String isTop;
	private Integer topDay;
	private String isAttach;
	private String postType;
	private Date createTime;
	private Date publishTime;
	private String userId;
	private String userName;
	private String filename;
	private String fileAddr;
	private String isAll;
	
	private String userIds;
	private String userNames;
	
	@JsonIgnore
	private List<SyUser> users;
	private String isNew;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIsPublish() {
		return isPublish;
	}
	public void setIsPublish(String isPublish) {
		this.isPublish = isPublish;
	}
	public String getIsTop() {
		return isTop;
	}
	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}
	public String getPostType() {
		return postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileAddr() {
		return fileAddr;
	}
	public void setFileAddr(String fileAddr) {
		this.fileAddr = fileAddr;
	}
	public String getIsAttach() {
		return isAttach;
	}
	public void setIsAttach(String isAttach) {
		this.isAttach = isAttach;
	}
	public String getIsAll() {
		return isAll;
	}
	public void setIsAll(String isAll) {
		this.isAll = isAll;
	}
	public List<SyUser> getUsers() {
		return users;
	}
	public void setUsers(List<SyUser> users) {
		this.users = users;
	}
	
	public Integer getTopDay() {
		return topDay;
	}
	public void setTopDay(Integer topDay) {
		this.topDay = topDay;
	}
	public String getIsNew() {
		if(this.publishTime!=null){
			Long between = new Date().getTime() - this.publishTime.getTime();
			Long hours = between/(1000*60*60);
			if(hours>0l && hours<(24*3)){
				return "1";
			}
		}
		return "0";
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public String getUserIds() {
		if(this.users!=null && !this.users.isEmpty()){
			String part = "";
			for(SyUser user : this.users){
				part += user.getUserId()+",";
			}
			return part;
		}
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public String getUserNames() {
		if(this.users!=null && !this.users.isEmpty()){
			String part = "";
			for(SyUser user : this.users){
				part += user.getUserName()+"_"+user.getTrueName()+",";
			}
			return part;
		}
		return userNames;
	}
	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}
}
