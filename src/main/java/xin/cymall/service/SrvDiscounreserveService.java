package xin.cymall.service;

import xin.cymall.entity.SrvDiscounreserve;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-25 17:24:03
 */
public interface SrvDiscounreserveService {
	
	SrvDiscounreserve get(String id);
	
	List<SrvDiscounreserve> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(SrvDiscounreserve srvDiscounreserve);
	
	void update(SrvDiscounreserve srvDiscounreserve);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);
}
