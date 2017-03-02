package com.rdfs.lyqc.system.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdfs.core.contants.Constants;
import com.rdfs.core.utils.StringUtils;
import com.rdfs.hibernate.service.impl.HibernateServiceSupport;
import com.rdfs.lyqc.cache.service.CacheUserService;
import com.rdfs.lyqc.common.utils.Md5Util;
import com.rdfs.lyqc.system.entity.SyDepartment;
import com.rdfs.lyqc.system.entity.SyPermSet;
import com.rdfs.lyqc.system.entity.SyUser;
import com.rdfs.lyqc.system.entity.SyUserDealer;
import com.rdfs.lyqc.system.entity.SyUserDepartment;
import com.rdfs.lyqc.system.service.UserService;

@Service
public class UserServiceImpl extends HibernateServiceSupport implements UserService {

	@Autowired
	private CacheUserService cacheUserService;
	
	@Override
	public void updateUser(SyUser user) {
		checkParms(user);
		user.setLastTime(new Date());

		updateEntity(user,"userName","address","trueName","sex","phone","email","cardType","cardId","birthday","postalCode","userType","lastTime","userDeparment");
		// 要启用事务
		SyUser syUser = getEntityByCode(SyUser.class,user.getUserId(),true);
		syUser.getUserDealers().clear();
		
		if (user.getUserDealers()!=null && !user.getUserDealers().isEmpty()) {
			List<SyUserDealer> dealers = user.getUserDealers();
			for(SyUserDealer dealer : dealers){
				dealer.setUser(user);
				syUser.getUserDealers().add(dealer);
			}
		}		
	}

	private void checkParms(SyUser user) {
		List<SyUser> list = getList(user, "userName");
		// 用户名
		if (user.getUserName() == null || ((user.getUserId() == null && list!=null && !list.isEmpty()) || (user.getUserId()!=null && list != null && list.size()>1 ))) {
			throw new RuntimeException("用户名重复或者为空!");
		}
		list = getList(user, "phone");
		// 手机
		if (user.getPhone() == null || ((user.getUserId() == null && list!=null && !list.isEmpty()) || (user.getUserId()!=null && list != null && list.size()>1 ))) {
			throw new RuntimeException("手机重复或者为空!");
		}
		list = getList(user, "email");
		// 邮箱
		if (user.getEmail() == null || ((user.getUserId() == null && list!=null && !list.isEmpty()) || (user.getUserId()!=null && list != null && list.size()>1 ))) {
			throw new RuntimeException("邮箱重复或者为空!");
		}

		if (user == null || user.getUserType() == null) {
			throw new RuntimeException("保存失败，用户类型不存在");
		}
		int userNameSize = user.getUserName().getBytes().length;
		if (userNameSize > 20) {
			throw new RuntimeException("保存失败，用户名超了20字符");
		}

		if(user.getUserDeparment()!=null && user.getUserType().equals(Constants.USER_TYPE.CS)){
			if ( user.getUserDeparment().getDepartmentId() == null) {
				throw new RuntimeException("保存失败，所属部门参数不存在");
			}
			if (StringUtils.isBlank(user.getUserDeparment().getUserPostion())) {
				throw new RuntimeException("保存失败，用户角色参数不存在");
			}
		} else {
			if (user.getUserDealers().isEmpty() && user.getUserType().equals(Constants.USER_TYPE.SD)) {
				throw new RuntimeException("保存失败，所属门店参数不存在");
			}
			for (SyUserDealer syUserDealer : user.getUserDealers()) {
				if (StringUtils.isBlank(syUserDealer.getUserPostion()) || syUserDealer.getDealer().getDealerCode() == null) {
					throw new RuntimeException("保存失败，门店职责参数不存在");
				}
			}
		}
	}

	@Override
	public void updateUserPassword(SyUser user) {
		user = getEntityByCode(SyUser.class, user.getUserId(), false);
		if (user.getPhone() == null || "".equals(user.getPhone())) {
			throw new RuntimeException("用户未填写手机号！");
		}
		String password = Md5Util.getMD5Str(StringUtils.getRandomChar(8));
		user.setPassword(password);
		updateEntity(user, "password");
	}
	
	private String getUserId(SyUser user){
		String sql = "SELECT MAX(USER_ID) AS USER_ID FROM SY_USER WHERE SUBSTRING(USER_ID,1,7) = ";
		String prefix = "";
		if(user.getUserType().equals(Constants.USER_TYPE.CS)){
			prefix = user.getUserDeparment().getDepartmentId().toString();
			sql += "'"+ prefix +"'";
		} else {
			SyUserDealer userDealer = user.getUserDealers().get(0);
			prefix = userDealer.getDealer().getDealerCode().toString();
			sql += "'" + prefix +"'";
		}
		List<?> list = getSession().createNativeQuery(sql).setResultTransfer(Transformers.ALIAS_TO_ENTITY_MAP).getResultList();
		if(list!=null && !list.isEmpty()){
			Map<?,?> map = (Map<?,?>) list.get(0);
			if(map.get("USER_ID")==null){
				return prefix + "001";
			}
			String userId = map.get("USER_ID").toString();
			String id = prefix + userId.substring(7,10);
			return String.valueOf(Integer.parseInt(id)+1);
		}
		return prefix + "001";
	}

	@Override
	public void saveUser(SyUser user) {
		checkParms(user); //校验
		
		if(StringUtils.isBlank(user.getUserId())){
			String id = getUserId(user);
			if(id == null){
				throw new RuntimeException("用户ID生成失败.");
			}
			user.setUserId(id);
			String pwd = StringUtils.getRandomChar(8);
			String str = Md5Util.getMD5Str(pwd);
			user.setPassword(str);
			user.setUserStatus(Constants.IS.YES);
			
			user.setCreateTime(new Date());
			user.setLastTime(new Date());
			
			if(user.getUserType().equals(Constants.USER_TYPE.SD)){
				user.setUserDeparment(null);
			}
			getSession().persist(user);
			
			if (user.getUserType().equals(Constants.USER_TYPE.CS)) {
				SyUserDepartment syUserDeparment = user.getUserDeparment();
				SyDepartment deparment = getEntityById(SyDepartment.class,syUserDeparment.getDepartmentId(),false);
				if (deparment == null || !Constants.IS.YES.equals(deparment.getStatus())) {
					throw new RuntimeException( "此部门不可用");
				}
				syUserDeparment.setUserId(user.getUserId());
				saveEntity(syUserDeparment);
			} else if (user.getUserType().equals(Constants.USER_TYPE.SD)) {
				List<SyUserDealer> dealers = user.getUserDealers();
				for (SyUserDealer syUserDealer : dealers) {
					syUserDealer.setUser(user);
				}
			}
			
			/*String person = user.getTrueName() + CatchCxtUtil.getDicDesc("_sex", user.getSex());
			String userName = user.getUserName();
			String password = pwd;
			String phone = user.getPhone();
			String param = "#person#="+person+"&#userName#="+userName+"&#pwd#="+password;
			new JHSendSmsUtil(phone, "10715", param).run();*/
		} else {
			updateUser(user );
		}
	}

	@Override
	public void updateSyUserPermSets(SyUser user, String[] permIds) {
		List<SyPermSet> permList = new ArrayList<SyPermSet>();
		for (String id : permIds) {
			SyPermSet permSet = getSession().find(SyPermSet.class, Integer.parseInt(id));
			permList.add(permSet);
		}
		user.setPermSets(permList);
		updateEntity(user, "permSets");
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T getEntityByCode(Class<T> type, String id, boolean init) {
		SyUser user = cacheUserService.getUser(id);
		if(!StringUtils.isBlankObj(user)){
			return (T) user;
		}
		return super.getEntityByCode(type, id, init);
	}
	
	
}
