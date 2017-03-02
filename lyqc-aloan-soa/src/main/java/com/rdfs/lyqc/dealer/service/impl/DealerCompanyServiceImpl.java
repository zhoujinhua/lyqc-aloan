package com.rdfs.lyqc.dealer.service.impl;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfs.core.contants.Constants;
import com.rdfs.core.utils.StringUtils;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cache.service.CacheDealerService;
import com.rdfs.lyqc.dealer.entity.SyDealerCompany;
import com.rdfs.lyqc.dealer.service.DealerCompanyService;

@Service
public class DealerCompanyServiceImpl extends HibernateServiceSupport implements DealerCompanyService {

	@Autowired
	private CacheDealerService cacheDealerService;
	
	@Override
	public void saveDealerCompany(SyDealerCompany company) {
		company.setUpdateTime(new Date());
		company.setStatus(Constants.IS.YES);
		saveEntity(company);
	}

	@Override
	public void updateDealerCompany(SyDealerCompany company) {
		company.setUpdateTime(new Date());
		updateEntity(company, "companyName","accountType","province","city","companyType","appNo","isVip"
				,"saleArea","accountName","accountIdno","accountBank","accountSubBank","bankProvince","bankCity","accountNo"
				,"remarks","status","updateTime");
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T getEntityById(Class<T> type, int id, boolean init) {
		SyDealerCompany company = cacheDealerService.getDealerCompany(id);
		if(!StringUtils.isBlankObj(company)){
			return (T) company;
		}
		return super.getEntityById(type, id, init);
	}
	
}
