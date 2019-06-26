package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.common.utils.UUID;
import xin.cymall.dao.SrvFoodDao;
import xin.cymall.entity.SrvFood;
import xin.cymall.service.SrvFoodService;




@Service("srvFoodService")
@Transactional
public class SrvFoodServiceImpl implements SrvFoodService {
	@Autowired
	private SrvFoodDao srvFoodDao;
	
	@Override
	public SrvFood get(String id){
		return srvFoodDao.get(id);
	}

	@Override
	public List<SrvFood> getList(Map<String, Object> map){
		return srvFoodDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvFoodDao.getCount(map);
	}

	@Override
	public void save(SrvFood srvFood){
		srvFood.setId(UUID.generateId());
		srvFoodDao.save(srvFood);
	}

	@Override
	public void update(SrvFood srvFood){
		srvFoodDao.update(srvFood);
	}

	@Override
	public void delete(String id){
		srvFoodDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvFoodDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvFood srvFood=get(id);
			srvFood.setStatus(stateValue);
            update(srvFood);
        }
    }
	
}
