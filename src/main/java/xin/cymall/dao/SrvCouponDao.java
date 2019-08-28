package xin.cymall.dao;

import xin.cymall.entity.SrvCoupon;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-27 13:47:41
 */
public interface SrvCouponDao extends BaseDao<SrvCoupon> {
    Long findByOrderNo(String orderNo);
	
}
