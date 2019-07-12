package xin.cymall.dao;

import xin.cymall.entity.wchart.SrvWxUser;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-12 15:25:58
 */
public interface SrvWxUserDao extends BaseDao<SrvWxUser> {
    SrvWxUser getByOpenId(String openId);
}
