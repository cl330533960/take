package xin.cymall.service;

import xin.cymall.entity.SrvFood;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-25 17:47:38
 */
public interface SrvFoodService {
	
	SrvFood get(String id);
	
	List<SrvFood> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvFood srvFood);
	
	void update(SrvFood srvFood);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);

	List<SrvFood> queryFoodByRestaurantId(String restaurantId);

	List<SrvFood> findHealthFood(Integer cal);
}
