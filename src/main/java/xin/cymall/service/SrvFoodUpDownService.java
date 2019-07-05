package xin.cymall.service;

import xin.cymall.entity.SrvFoodUpDown;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-05 23:30:59
 */
public interface SrvFoodUpDownService {
	
	SrvFoodUpDown get(String id);
	
	List<SrvFoodUpDown> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvFoodUpDown srvFoodUpDown);
	
	void update(SrvFoodUpDown srvFoodUpDown);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);

	void batchUporDown(List<SrvFoodUpDown> list,Integer status);
}
