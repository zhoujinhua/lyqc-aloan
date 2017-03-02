package com.rdfs.lyqc.cache.service;

import java.util.List;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyDictItem;

public interface CacheMasterService extends HibernateService{

	String getParam(String key);

	List<SyDictItem> getDicList(String key);

	String getDicDesc(String key, String code);

	void cacheParamData();

	void cacheDictData();

	void cacheDict(SyDictItem dictItem);

	void cacheParamOption(String fieldKey, String value);

}
