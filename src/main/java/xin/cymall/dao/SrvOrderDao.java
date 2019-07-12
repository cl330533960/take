package xin.cymall.dao;

import xin.cymall.entity.SrvOrder;

import java.util.List;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-26 14:01:40
 */
public interface SrvOrderDao extends BaseDao<SrvOrder> {
	SrvOrder receiptOrder(SrvOrder srvOrder);
	SrvOrder getByOderNo(String orderNo);
}
