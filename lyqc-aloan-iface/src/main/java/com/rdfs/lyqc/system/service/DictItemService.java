package com.rdfs.lyqc.system.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyDictItem;

public interface DictItemService extends HibernateService {

	SyDictItem saveDictItem(SyDictItem arg);

}
