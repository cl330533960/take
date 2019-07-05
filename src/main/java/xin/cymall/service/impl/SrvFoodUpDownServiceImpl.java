package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvFoodUpDownDao;
import xin.cymall.entity.SrvFoodUpDown;
import xin.cymall.service.SrvFoodUpDownService;




@Service("srvFoodUpDownService")
@Transactional
public class SrvFoodUpDownServiceImpl implements SrvFoodUpDownService {
	@Autowired
	private SrvFoodUpDownDao srvFoodUpDownDao;
	
	@Override
	public SrvFoodUpDown get(String id){
		return srvFoodUpDownDao.get(id);
	}

	@Override
	public List<SrvFoodUpDown> getList(Map<String, Object> map){
		return srvFoodUpDownDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvFoodUpDownDao.getCount(map);
	}

	@Override
	public void save(SrvFoodUpDown srvFoodUpDown){
		srvFoodUpDownDao.save(srvFoodUpDown);
	}

	@Override
	public void update(SrvFoodUpDown srvFoodUpDown){
		srvFoodUpDownDao.update(srvFoodUpDown);
	}

	@Override
	public void delete(String id){
		srvFoodUpDownDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvFoodUpDownDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvFoodUpDown srvFoodUpDown=get(id);
            update(srvFoodUpDown);
        }
    }

	@Override
	@Transactional
	public void batchUporDown(List<SrvFoodUpDown> list,Integer status) {
		for(SrvFoodUpDown srvFoodUpDown : list){
			if(status == 1){
				srvFoodUpDownDao.save(srvFoodUpDown);
			}else
				srvFoodUpDownDao.downFood(srvFoodUpDown);

		}

	}

}
