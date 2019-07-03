package xin.cymall.service;

import xin.cymall.entity.SrvOrderFood;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-28 14:55:15
 */
public interface SrvOrderFoodService {
	
	SrvOrderFood get(String id);
	
	List<SrvOrderFood> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvOrderFood srvOrderFood);
	
	void update(SrvOrderFood srvOrderFood);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}
