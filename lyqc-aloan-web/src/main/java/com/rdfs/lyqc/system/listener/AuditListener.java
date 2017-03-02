package com.rdfs.lyqc.system.listener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.springframework.stereotype.Component;

import com.rdfs.core.utils.JsonUtil;
import com.rdfs.core.utils.StringUtils;

@Component
public class AuditListener  implements PostInsertEventListener,PostUpdateEventListener, PostDeleteEventListener{

	/**
	 * hibernate事件监听
	 */
	private static final long serialVersionUID = 6565815200944962178L;
	private static Map<String,String> _table = new HashMap<String,String>();
	private static List<String> tables = new ArrayList<String>();
	static {
		//从字典取
		_table.put("SyParameter", "人员信息表");
		for (Entry<String, String> entry : _table.entrySet()) {
			tables.add(entry.getKey());
		}
	}
	@Override  
	public void onPostInsert(PostInsertEvent event) {
		//新增监听
	}  
	
	@Override  
	public void onPostUpdate(PostUpdateEvent event) {
		Class<?> clazz = event.getEntity().getClass();
		String beanName = clazz.getSimpleName();
		if(!tables.contains(beanName))
			return;
    	Object[] oldState = event.getOldState();
    	Object[] newState = event.getState();
    	String[] fields = event.getPersister().getPropertyNames();
    	
    	try {
			Object objO = clazz.newInstance();
			Object objN = clazz.newInstance();
			boolean flag = false;
			for(int i = 0 ; i < fields.length ; i ++){
				if(!StringUtils.compare(oldState[i], newState[i])){
					flag = true;
					Field field = clazz.getDeclaredField(fields[i]);
					field.setAccessible(true);
					
					//再加一层对数据类型的校验
					
					field.set(objO, oldState[i]);
					field.set(objN, newState[i]);
				}
			}
			if(flag){
				System.out.println(JsonUtil.toJson(objO));
				System.out.println(JsonUtil.toJson(objN));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override  
	public void onPostDelete(PostDeleteEvent event) { 
		//删除监听
	}
}
