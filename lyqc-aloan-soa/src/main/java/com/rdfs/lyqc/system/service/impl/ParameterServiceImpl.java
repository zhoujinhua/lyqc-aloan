package com.rdfs.lyqc.system.service.impl;

import org.springframework.stereotype.Service;

import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.system.entity.SyParameter;
import com.rdfs.lyqc.system.service.ParameterService;

@Service
public class ParameterServiceImpl extends HibernateServiceSupport implements ParameterService {

	@Override
	public SyParameter saveParameter(SyParameter param) {
		if(param.getId() == null){
			saveEntity(param);
		} else {
			updateEntity(param);
		}
		return param;
	}

}
