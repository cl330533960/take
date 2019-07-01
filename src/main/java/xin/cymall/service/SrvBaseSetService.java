package xin.cymall.service;

import xin.cymall.entity.SrvBaseSet;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-01 21:09:34
 */
public interface SrvBaseSetService {
	
	SrvBaseSet get(String id);
	
	List<SrvBaseSet> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvBaseSet srvBaseSet);
	
	void update(SrvBaseSet srvBaseSet);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}
