package com.rdfs.lyqc.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfs.core.bean.UserDto;
import com.rdfs.core.contants.Constants;
import com.rdfs.hibernate.enums.OperMode;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cache.service.CacheResourceService;
import com.rdfs.lyqc.common.dto.TreeDto;
import com.rdfs.lyqc.common.utils.JacksonUtil;
import com.rdfs.lyqc.system.entity.SyMenu;
import com.rdfs.lyqc.system.entity.SyPermSet;
import com.rdfs.lyqc.system.entity.SyResource;
import com.rdfs.lyqc.system.entity.SyUser;
import com.rdfs.lyqc.system.service.PermSetService;
import com.rdfs.lyqc.system.service.TreeService;

@Service
public class PermSetServiceImpl extends HibernateServiceSupport implements PermSetService {

	@Autowired
	private CacheResourceService cacheResourceService;
	
	@Autowired
	private TreeService treeService;
	
	@Override
	public List<TreeDto> getPermSetTree(SyUser user) throws Exception {
		user = getEntityByCode(SyUser.class,user.getUserId(),true);
		SyPermSet permset = new SyPermSet();
		permset.setPermStatus(Constants.IS.YES);
		
		List<SyPermSet> permSets = getList(permset,OperMode.EQ, "permStatus");
		List<TreeDto> treeList = treeService.getList(permSets, "id", "permName", null, user.getPermSets());
		return treeList;
	}

	@Override
	public void updatePermSet(SyPermSet permSet, String[] split) {
		List<SyResource> itemList = new ArrayList<SyResource>();
		for(String part : split){
			itemList.add(getSession().find(SyResource.class, part));
		}
		permSet.setItems(itemList);
		updateEntity(permSet,"items");
	}

	@Override
	public List<TreeDto> getMenuTree(SyPermSet permSet) throws Exception {
		permSet = getSession().find(SyPermSet.class, permSet.getId());
		List<SyMenu> menuList = getSession().getCriteria(SyMenu.class).getResultList();
		List<SyResource> itemList = getSession().getCriteria(SyResource.class).getResultList();
		List<TreeDto> treeList = treeService.getList(menuList, "menuId", "menuTitle", null, null);
		treeList.addAll(treeService.getList(itemList, "itemId", "itemTitle", "menuId", permSet.getItems()));
		return treeList;
	}

	@SuppressWarnings("unchecked")
	public Map<String,List<SyResource>> getAvaliableUserPermItem(UserDto user) {
		Map<String,List<SyResource>> map = new HashMap<String, List<SyResource>>();
		
		String sql = "SELECT DISTINCT ITEM_ID FROM SY_PERM_ITEM WHERE PERM_ID IN (SELECT PERM_ID FROM SY_USER_PERMSET WHERE USER_ID="+user.getUserId()+") ORDER BY ITEM_ID ASC";
		List<Object> list = getSession().createNativeQuery(sql).getResultList();
		if(list!=null && !list.isEmpty()){
			for(Object obj : list){
				String itemId = obj.toString();
				SyResource syItem = cacheResourceService.getResource(itemId);
				if(syItem == null){
					syItem = getSession().find(SyResource.class, itemId);
				}
				
				if(syItem!=null){
					if(map.get(syItem.getMenuId())==null){
						map.put(syItem.getMenuId(), new ArrayList<SyResource>());
					}
					map.get(syItem.getMenuId()).add(syItem);
				}
			}
		}
		return map;
	}
	
	@Override
	public String getUserMenuTree(UserDto user) {
		Map<String,List<SyResource>> map = getAvaliableUserPermItem(user);
		List<SyMenu> menuList =  getSession().getCriteria(SyMenu.class).getResultList();
		List<SyMenu> tempList = new ArrayList<SyMenu>();
		
		for(SyMenu menu : menuList){
			if(map.get(menu.getMenuId())!=null){
				menu.setItems(map.get(menu.getMenuId()));
			} else {
				tempList.add(menu);
			}
		}
		
		menuList.removeAll(tempList);
		return JacksonUtil.toJson(menuList);                 
	}

	@Override
	public void savePermSet(SyPermSet permSet, UserDto user) {
		if(permSet.getId()!=null){
			permSet.setUpdateTime(new Date());
			updateEntity(permSet, "permStatus","permName","updateTime","permDesc");
		} else {
			permSet.setCreateTime(new Date());
			permSet.setCreateUser(user.getTrueName());
			
			saveEntity(permSet);
		}		
	}

}
