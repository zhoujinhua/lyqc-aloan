package com.rdfs.lyqc.cust.service;

import java.util.List;

import com.rdfs.framework.core.bean.TreeDto;
import com.rdfs.framework.hibernate.service.HibernateService;
import com.rdfs.lyqc.cust.entity.DhContactPhone;

public interface ContactPhoneService extends HibernateService {

	List<TreeDto> formatCustTree(DhContactPhone phone) throws Exception;

}
