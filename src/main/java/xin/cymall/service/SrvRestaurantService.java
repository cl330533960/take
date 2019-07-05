package xin.cymall.service;

import xin.cymall.entity.SrvRestaurant;
import xin.cymall.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-21 18:55:54
 */
public interface SrvRestaurantService {
	
	SrvRestaurant get(String id);
	
	List<SrvRestaurant> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvRestaurant srvRestaurant,SysUser user);
	
	void update(SrvRestaurant srvRestaurant);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);

	String getArea(String area);

	SrvRestaurant getByUserId(String userId);
}
