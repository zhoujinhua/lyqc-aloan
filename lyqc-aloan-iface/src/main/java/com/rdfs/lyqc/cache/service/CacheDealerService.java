package com.rdfs.lyqc.cache.service;

import java.util.List;

import com.rdfs.hibernate.service.HibernateService;
import com.rdfs.lyqc.dealer.entity.SyDealer;
import com.rdfs.lyqc.dealer.entity.SyDealerCompany;

public interface CacheDealerService extends HibernateService{

	void cacheDealerData();

	List<SyDealer> getDealerList();

	SyDealer getDealer(Integer dealerCode);

	List<SyDealerCompany> getDealerCompanyList();

	SyDealerCompany getDealerCompany(Integer companyCode);

	void cacheDealer(SyDealer dealer);

	void deleteDealer(SyDealer dealer);

	void cacheDealerCompany(SyDealerCompany dealerCompany);

	void deleteDealerCompany(SyDealerCompany dealerCompany);

}
