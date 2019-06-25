package xin.cymall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

import xin.cymall.dao.SrvDiscounreserveDao;
import xin.cymall.entity.SrvDiscounreserve;
import xin.cymall.service.SrvDiscounreserveService;




@Service("srvDiscounreserveService")
@Transactional
public class SrvDiscounreserveServiceImpl implements SrvDiscounreserveService {
	@Autowired
	private SrvDiscounreserveDao srvDiscounreserveDao;
	
	@Override
	public SrvDiscounreserve get(String id){
		return srvDiscounreserveDao.get(id);
	}

	@Override
	public List<SrvDiscounreserve> getList(Map<String, Object> map){
		return srvDiscounreserveDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvDiscounreserveDao.getCount(map);
	}

	@Override
	public void save(SrvDiscounreserve srvDiscounreserve){
		srvDiscounreserveDao.save(srvDiscounreserve);
	}

	@Override
	public void update(SrvDiscounreserve srvDiscounreserve){
		srvDiscounreserveDao.update(srvDiscounreserve);
	}

	@Override
	public void delete(String id){
		srvDiscounreserveDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvDiscounreserveDao.deleteBatch(ids);
	}

    @Override
    public void updateState(String[] ids,String stateValue) {
        for (String id:ids){
			SrvDiscounreserve srvDiscounreserve=get(id);
			srvDiscounreserve.setStatus(stateValue);
            update(srvDiscounreserve);
        }
    }
	
}
