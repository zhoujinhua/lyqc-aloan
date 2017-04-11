package com.rdfs.lyqc.shouc.service;

import com.rdfs.framework.hibernate.service.HibernateService;
import com.rdfs.lyqc.shouc.entity.DhClocarReg;

public interface ClocarRegService extends HibernateService {

	void saveReg(DhClocarReg reg);

}
