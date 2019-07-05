package xin.cymall.dao;

import xin.cymall.entity.SrvRestaurant;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-21 18:55:54
 */
public interface SrvRestaurantDao extends BaseDao<SrvRestaurant> {

    List<SrvRestaurant> getBalanceList(Map<String, Object> map);


    int getBalanceCount(Map<String, Object> map);

    void updateBalance(Double balance,String id);

    SrvRestaurant getBalance(String id);

    SrvRestaurant getByUserId(String userId);

	
}
