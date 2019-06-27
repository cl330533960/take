package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.common.utils.StringUtil;
import xin.cymall.common.utils.UUID;
import xin.cymall.dao.AreaDao;
import xin.cymall.dao.SrvRestaurantDao;
import xin.cymall.dao.SysUserDao;
import xin.cymall.entity.SrvRestaurant;
import xin.cymall.entity.SysUser;
import xin.cymall.service.SrvRestaurantService;
import xin.cymall.service.SysUserService;


@Service("srvRestaurantService")
@Transactional
public class SrvRestaurantServiceImpl implements SrvRestaurantService {
	@Autowired
	private SrvRestaurantDao srvRestaurantDao;
	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private AreaDao areaDao;
	
	@Override
	public SrvRestaurant get(String id){
		return srvRestaurantDao.get(id);
	}

	@Override
	public List<SrvRestaurant> getList(Map<String, Object> map){
		return srvRestaurantDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvRestaurantDao.getCount(map);
	}

	@Override
	@Transactional
	public void save(SrvRestaurant srvRestaurant,SysUser user){
		user.setUsername(srvRestaurant.getUsername());
		user.setRoleIdList(srvRestaurant.getRoleIdList());
		sysUserService.save(user);
		srvRestaurant.setId(UUID.generateId());
		srvRestaurant.setUserId(user.getUserId());
		srvRestaurantDao.save(srvRestaurant);

	}

	@Override
	public void update(SrvRestaurant srvRestaurant){
		srvRestaurantDao.update(srvRestaurant);
	}

	@Override
	public void delete(String id){
		srvRestaurantDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvRestaurantDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvRestaurant srvRestaurant=get(id);
			srvRestaurant.setStatus(stateValue);
            update(srvRestaurant);
        }
    }

	@Override
	public String getArea(String area){
		if(!StringUtil.isEmpty(area)) {
			String[] areas = area.split(",");
			return areaDao.getAreaInfo(areas);
		}
		return "";
	}
	
}
