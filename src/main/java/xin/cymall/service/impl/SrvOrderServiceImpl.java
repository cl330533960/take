package xin.cymall.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import xin.cymall.common.enumresource.OrderStatusEnum;
import xin.cymall.common.utils.OrderUtil;
import xin.cymall.common.utils.UUID;
import xin.cymall.dao.SrvOrderDao;
import xin.cymall.dao.SrvOrderFoodDao;
import xin.cymall.dao.SrvWxUserDao;
import xin.cymall.entity.SrvOrder;
import xin.cymall.entity.SrvOrderFood;
import xin.cymall.entity.wchart.OrderFood;
import xin.cymall.entity.wchart.SrvWxUser;
import xin.cymall.entity.wchart.WxOrder;
import xin.cymall.service.SrvOrderService;




@Service("srvOrderService")
@Transactional
public class SrvOrderServiceImpl implements SrvOrderService {
	@Autowired
	private SrvOrderDao srvOrderDao;
	@Autowired
	private SrvWxUserDao srvWxUserDao;
	@Autowired
	private SrvOrderFoodDao srvOrderFoodDao;

	@Override
	public SrvOrder get(String id){
		return srvOrderDao.get(id);
	}

	@Override
	public List<SrvOrder> getList(Map<String, Object> map){
		return srvOrderDao.getList(map);
	}

	@Override
	public int getCount(Map<String, Object> map){
		return srvOrderDao.getCount(map);
	}

	@Transactional
	@Override
	public String save(WxOrder wxOrder) throws IOException {
		SrvOrder order = new SrvOrder();
		order.setId(UUID.generateId());
		SrvWxUser srvWxUser =srvWxUserDao.getByOpenId(wxOrder.getWxId());
		order.setOrderNo(OrderUtil.generateOrderNo(wxOrder.getOrderType()));
		order.setOrderType(wxOrder.getOrderType());
		order.setUserId(srvWxUser.getId());
		order.setRestaurantId(wxOrder.getRestaurantId());
		if(wxOrder.getPackFee()!=null && wxOrder.getPackFee()>0)
			order.setPackFee(wxOrder.getPackFee());
		if(wxOrder.getWayFee()!=null && wxOrder.getWayFee()>0)
			order.setWayFee(wxOrder.getWayFee());
		order.setUserPayFee(wxOrder.getUserPayAmount());
		order.setOrderTotal(wxOrder.getTotalAmount());
		order.setRestaurantTotal(wxOrder.getRestaurantTotal());
		order.setRemark(wxOrder.getRemark());
		ObjectMapper mapper = new ObjectMapper();
		List<OrderFood> list = mapper.readValue(wxOrder.getFoodList(),new TypeReference<List<OrderFood>>() { });
		for(OrderFood orderFood : list){
			SrvOrderFood srvOrderFood = new SrvOrderFood();
			srvOrderFood.setId(UUID.generateId());
			srvOrderFood.setFoodId(orderFood.getId());
			srvOrderFood.setOrderId(order.getId());
			srvOrderFood.setPrice(orderFood.getSysPrice());
			srvOrderFood.setTotalPrice(orderFood.getTotalPrice());
			srvOrderFood.setFoodName(orderFood.getName());
			srvOrderFood.setNumber(orderFood.getNumber());
			order.setRestaurantId(orderFood.getRid());
			srvOrderFoodDao.save(srvOrderFood);
		}
		order.setStatus(OrderStatusEnum.ORDRT_STATUS1.getCode());
		srvOrderDao.save(order);
		return order.getOrderNo();
	}

	public void updateOrderSuccessCallback(String orderNo){
		SrvOrder srvOrder = srvOrderDao.getByOderNo(orderNo);
		if(srvOrder != null) {
			srvOrder.setStatus(OrderStatusEnum.ORDRT_STATUS2.getCode());
			update(srvOrder);
		}
	}


	@Override
	public void update(SrvOrder srvOrder){
		srvOrderDao.update(srvOrder);
	}

	@Override
	public void delete(String id){
		srvOrderDao.delete(id);
	}

	@Override
	public void deleteBatch(String[] ids){
		srvOrderDao.deleteBatch(ids);
	}

	@Override
	public void updateState(String[] ids,String stateValue) {
		for (String id:ids){
			SrvOrder srvOrder=get(id);
			srvOrder.setStatus(stateValue);
			update(srvOrder);
		}
	}

	@Override
	public SrvOrder receiptOrder(SrvOrder srvOrder) {
		return srvOrderDao.receiptOrder(srvOrder);
	}

}
