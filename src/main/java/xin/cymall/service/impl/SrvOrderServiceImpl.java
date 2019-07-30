package xin.cymall.service.impl;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.common.utils.LogUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import xin.cymall.common.dadaexpress.DaDaExpressUtil;
import xin.cymall.common.enumresource.OrderStatusEnum;
import xin.cymall.common.utils.AppPush;
import xin.cymall.common.utils.OrderUtil;
import xin.cymall.common.utils.StringUtil;
import xin.cymall.common.utils.UUID;
import xin.cymall.dao.SrvOrderDao;
import xin.cymall.dao.SrvOrderFoodDao;
import xin.cymall.dao.SrvRestaurantDao;
import xin.cymall.dao.SrvWxUserDao;
import xin.cymall.entity.SrvOrder;
import xin.cymall.entity.SrvOrderFood;
import xin.cymall.entity.SrvRestaurant;
import xin.cymall.entity.wchart.OrderFood;
import xin.cymall.entity.wchart.SrvWxUser;
import xin.cymall.entity.wchart.WxOrder;
import xin.cymall.service.PushService;
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
	@Autowired
	private SrvRestaurantDao srvRestaurantDao;

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
		order.setUserAddrId(wxOrder.getUserAddrId());
		if(wxOrder.getPackFee()!=null && wxOrder.getPackFee()>0)
			order.setPackFee(wxOrder.getPackFee());
		else
			order.setPackFee(0);
		if(wxOrder.getWayFee()!=null && wxOrder.getWayFee()>0) {
			order.setWayFee(wxOrder.getWayFee());
			order.setDadaOrder(wxOrder.getDadaOrder());
			order.setExpressNum(wxOrder.getExpressNum());
			order.setExpressCompnay("达达快递");
		}
		else
			order.setWayFee(0);
		order.setUserPayFee(wxOrder.getUserPayAmount());
		order.setOrderTotal(wxOrder.getTotalAmount());
		order.setRestaurantTotal(wxOrder.getRestaurantTotal());
		order.setRemark(wxOrder.getRemark());
		ObjectMapper mapper = new ObjectMapper();
		List<OrderFood> list = mapper.readValue(wxOrder.getFoodList(), new TypeReference<List<OrderFood>>() {});
		list.stream().collect(Collectors.groupingBy(obj -> obj,Collectors.counting())).forEach((orderFood,num) -> {
			SrvOrderFood srvOrderFood = new SrvOrderFood();
			srvOrderFood.setId(UUID.generateId());
			srvOrderFood.setFoodId(orderFood.getId());
			srvOrderFood.setOrderId(order.getId());
			srvOrderFood.setPrice(orderFood.getSysPrice());
			srvOrderFood.setTotalPrice(num.intValue()*orderFood.getSysPrice());
			srvOrderFood.setFoodName(orderFood.getName());
			srvOrderFood.setNumber(num.intValue());
			order.setRestaurantId(orderFood.getRid());
			srvOrderFoodDao.save(srvOrderFood);
		});
		order.setStatus(OrderStatusEnum.ORDRT_STATUS1.getCode());
		srvOrderDao.save(order);
		return order.getOrderNo();
	}

	public void updateOrderSuccessCallback(String orderNo){
		SrvOrder srvOrder = srvOrderDao.getByOderNo(orderNo);
		if(srvOrder != null) {
			srvOrder.setStatus(OrderStatusEnum.ORDRT_STATUS3.getCode());
			//支付成功 推送给app
			SrvRestaurant srvRestaurant = srvRestaurantDao.get(srvOrder.getRestaurantId());
			HashMap<String, String> message = new HashMap();
			message.put("title","你有一条新的订单");
			message.put("titleText","你有一条新的订单");
			message.put("transText", "你有一条新的订单");
			System.out.println((AppPush.pushMsgToSingle(srvRestaurant.getClientId(), message).getResponse()));
			if("1".equals(srvRestaurant.getAutoReceipt()) && "1".equals(srvOrder.getOrderType())){
				//自动接单 需要订单类型为外卖
				srvOrder.setStatus(OrderStatusEnum.ORDRT_STATUS4.getCode());
				srvOrder.setReceiptTime(new Date());
				//提交达达订单
				DaDaExpressUtil.addAfterQuery(srvOrder.getExpressNum());

			}
			update(srvOrder);
		}
	}

	@Override
	@Transactional
	public void updateOrderDada(String dadaOrder, String orderStatus,String expressName,String expressPhone) {
		SrvOrder srvOrder = srvOrderDao.queryOrderByDada(dadaOrder);
		srvOrder.setStatus(orderStatus);
		if(!StringUtil.isEmpty(expressName))
			srvOrder.setExpressName(expressName);
		if(!StringUtil.isEmpty(expressPhone))
			srvOrder.setExpressPhone(expressPhone);
		if(orderStatus.equals(OrderStatusEnum.ORDRT_STATUS7.getCode())){
			srvRestaurantDao.updateBalance(srvOrder.getUserPayFee(),srvOrder.getRestaurantId());
		}
		srvOrderDao.update(srvOrder);
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
