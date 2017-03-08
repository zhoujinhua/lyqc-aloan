package com.rdfs.lyqc.cust.service;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.cust.entity.DhContactAddr;
import com.rdfs.lyqc.cust.entity.DhPhoneRemark;

public interface PhoneRemarkService extends HibernateService {

	void savePhoneRemark(DhPhoneRemark remark, DhContactAddr addr);

}
