package com.rdfs.lyqc.system.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.rdfs.core.utils.StringUtils;
import com.rdfs.hibernate.utils.BeanInvokeUtils;
import com.rdfs.lyqc.common.dto.TreeDto;
import com.rdfs.lyqc.system.service.TreeService;

@Service
public class TreeServiceImpl implements TreeService {

	@Override
	public <T extends Serializable> List<TreeDto> getList(List<T> list, String idField, String nameField, String pIdField, List<T> pList) throws Exception{
		List<TreeDto> treeList = Lists.newArrayList();
		if(list!=null && !list.isEmpty()){
			List<String> idList = Lists.newArrayList();
			if(pList!=null && !pList.isEmpty()){
				for(T t : pList){
					Object id = BeanInvokeUtils.invokeMethod(t, idField);
					if(!StringUtils.isBlankObj(id)){
						idList.add(String.valueOf(id));
					}
				}
			}
			for(T t : list){
				TreeDto node = new TreeDto();
				Object id = BeanInvokeUtils.invokeMethod(t, idField);
				if(!StringUtils.isBlankObj(id)){
					node.setId(String.valueOf(id));
				}
				Object name = BeanInvokeUtils.invokeMethod(t, nameField);
				if(!StringUtils.isBlankObj(name)){
					node.setName(String.valueOf(name));
				}
				if(!StringUtils.isBlank(pIdField)){
					Object pId = BeanInvokeUtils.invokeMethod(t, pIdField);
					if(!StringUtils.isBlankObj(pId)){
						node.setpId(String.valueOf(pId));
					} else {
						node.setpId(pIdField);
					}
				} else {
					node.setpId("0");
				}
				if(idList.contains(node.getId())){
					node.setChecked(true);
				}
				treeList.add(node);
			}
		}
		return treeList;
	}
}
