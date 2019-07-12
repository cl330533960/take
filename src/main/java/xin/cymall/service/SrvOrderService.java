package xin.cymall.service;

import xin.cymall.entity.SrvOrder;
import xin.cymall.entity.wchart.WxOrder;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-26 14:01:40
 */
public interface SrvOrderService {
	
	SrvOrder get(String id);
	
	List<SrvOrder> getList(Map<String, Object> map);
	
	int getCount(Map<String, Object> map);
	
	void save(WxOrder wxOrder);
	
	void update(SrvOrder srvOrder);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

    void updateState(String[] ids, String stateValue);

	SrvOrder receiptOrder(SrvOrder srvOrder);


}
