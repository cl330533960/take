package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvOrderFoodDao;
import xin.cymall.entity.SrvOrderFood;
import xin.cymall.service.SrvOrderFoodService;




@Service("srvOrderFoodService")
@Transactional
public class SrvOrderFoodServiceImpl implements SrvOrderFoodService {
	@Autowired
	private SrvOrderFoodDao srvOrderFoodDao;
	
	@Override
	public SrvOrderFood get(String id){
		return srvOrderFoodDao.get(id);
	}

	@Override
	public List<SrvOrderFood> getList(Map<String, Object> map){
		return srvOrderFoodDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvOrderFoodDao.getCount(map);
	}

	@Override
	public void save(SrvOrderFood srvOrderFood){
		srvOrderFoodDao.save(srvOrderFood);
	}

	@Override
	public void update(SrvOrderFood srvOrderFood){
		srvOrderFoodDao.update(srvOrderFood);
	}

	@Override
	public void delete(String id){
		srvOrderFoodDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvOrderFoodDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvOrderFood srvOrderFood=get(id);
//			srvOrderFood.s(stateValue);
            update(srvOrderFood);
        }
    }
	
}
