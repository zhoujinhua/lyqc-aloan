package com.rdfs.lyqc.system.service.impl;

import org.springframework.stereotype.Service;

import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.system.entity.SyDictItem;
import com.rdfs.lyqc.system.service.DictItemService;

@Service
public class DictItemServiceImpl extends HibernateServiceSupport implements DictItemService {

	@Override
	public SyDictItem saveDictItem(SyDictItem dict) {
		if(dict.getId()!=null){
			saveEntity(dict);
		} else {
			getSession().update(dict);
		}
		return dict;
	}

}
