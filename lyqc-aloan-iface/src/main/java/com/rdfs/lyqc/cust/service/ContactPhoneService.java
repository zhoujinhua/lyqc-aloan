package com.rdfs.lyqc.cust.service;

import java.util.List;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.common.dto.TreeDto;
import com.rdfs.lyqc.cust.entity.DhContactPhone;

public interface ContactPhoneService extends HibernateService {

	List<TreeDto> formatCustTree(DhContactPhone phone) throws Exception;

}
