package com.rdfs.lyqc.dianc.service;

import com.rdfs.framework.hibernate.service.HibernateService;
import com.rdfs.lyqc.dianc.entity.DhCollectionReg;

public interface CollectionRegService extends HibernateService {

	void saveReg(DhCollectionReg reg);

}
