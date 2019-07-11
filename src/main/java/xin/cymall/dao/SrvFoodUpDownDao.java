package xin.cymall.dao;

import xin.cymall.entity.SrvFood;
import xin.cymall.entity.SrvFoodUpDown;

/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-05 23:30:59
 */
public interface SrvFoodUpDownDao extends BaseDao<SrvFoodUpDown> {
    void downFood(SrvFoodUpDown srvFoodUpDown);
}
