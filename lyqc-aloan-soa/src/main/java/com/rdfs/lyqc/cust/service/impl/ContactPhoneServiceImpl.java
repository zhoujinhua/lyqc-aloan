package com.rdfs.lyqc.cust.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.common.dto.TreeDto;
import com.rdfs.lyqc.cust.entity.DhContactPhone;
import com.rdfs.lyqc.cust.service.ContactPhoneService;
import com.rdfs.lyqc.system.service.TreeService;

@Service
public class ContactPhoneServiceImpl extends HibernateServiceSupport implements ContactPhoneService {

	@Autowired
	private TreeService treeService;
	
	@Override
	public List<TreeDto> formatCustTree(DhContactPhone phone) throws Exception {
		List<TreeDto> treeList = new ArrayList<>();
		List<DhContactPhone> phones = getList(phone, "appCode", "contactType");
		
		treeList.addAll(treeService.getList(phones, "id", "contactName", null, null));
		return treeList;
	}

}
