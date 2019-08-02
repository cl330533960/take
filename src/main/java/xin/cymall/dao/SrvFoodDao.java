package xin.cymall.dao;

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
public interface SrvFoodDao extends BaseDao<SrvFood> {

    List<SrvFood> queryFoodByRestaurantId(String restaurantId);

    List<SrvFood> findHealthFood(Integer cal);

    Map<String,Object> queryfoodInfo(String fooId,String restaurantId);
}
