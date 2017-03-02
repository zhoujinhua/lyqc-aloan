package com.rdfs.lyqc.system.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.system.entity.SyParameter;

public interface ParameterService extends HibernateService {

	SyParameter saveParameter(SyParameter param);

}
