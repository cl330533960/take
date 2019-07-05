package xin.cymall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-26 14:01:40
 */
public class SrvOrder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**主键ID**/
	private String id;
	/**订单号**/
	private String orderNo;
	/**用户ID**/
	private String userId;
	/**商户ID**/
	private String restaurantId;
	/**用户地址ID**/
	private String userAddrId;
	/**快递公司**/
	private String expressCompnay;
	/**快递单号**/
	private String expressNum;
	/**骑手名称**/
	private String expressName;
	/**骑手电话**/
	private String expressPhone;
	/**订单状态**/
	private String status;
	/**总金额**/
	private String orderTotal;
	/**评论**/
	private String remark;
	/**外卖类型**/
	private String orderType;
	/**用户支付费用**/
	private String userPayFee;
	/**运费**/
	private String wayFee;
	/**包装费**/
	private String packFee;
	/**优惠券ID**/
	private String couponId;
	/**折扣**/
	private String discount;
	/**下单时间**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date orderTime;

	private String wxName;
	private String phone;
	private String restaurantName;
	private String receiveAddr;
	private String receivePhone;
	private String receiveName;
	private List<SrvOrderFood> foodList;

	/**
	 * 设置：主键ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：订单号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：商户ID
	 */
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	/**
	 * 获取：商户ID
	 */
	public String getRestaurantId() {
		return restaurantId;
	}
	/**
	 * 设置：用户地址ID
	 */
	public void setUserAddrId(String userAddrId) {
		this.userAddrId = userAddrId;
	}
	/**
	 * 获取：用户地址ID
	 */
	public String getUserAddrId() {
		return userAddrId;
	}
	/**
	 * 设置：快递公司
	 */
	public void setExpressCompnay(String expressCompnay) {
		this.expressCompnay = expressCompnay;
	}
	/**
	 * 获取：快递公司
	 */
	public String getExpressCompnay() {
		return expressCompnay;
	}
	/**
	 * 设置：快递单号
	 */
	public void setExpressNum(String expressNum) {
		this.expressNum = expressNum;
	}
	/**
	 * 获取：快递单号
	 */
	public String getExpressNum() {
		return expressNum;
	}
	/**
	 * 设置：骑手名称
	 */
	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}
	/**
	 * 获取：骑手名称
	 */
	public String getExpressName() {
		return expressName;
	}
	/**
	 * 设置：骑手电话
	 */
	public void setExpressPhone(String expressPhone) {
		this.expressPhone = expressPhone;
	}
	/**
	 * 获取：骑手电话
	 */
	public String getExpressPhone() {
		return expressPhone;
	}
	/**
	 * 设置：订单状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：订单状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：总金额
	 */
	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}
	/**
	 * 获取：总金额
	 */
	public String getOrderTotal() {
		return orderTotal;
	}
	/**
	 * 设置：评论
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：评论
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：外卖类型
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：外卖类型
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * 设置：用户支付费用
	 */
	public void setUserPayFee(String userPayFee) {
		this.userPayFee = userPayFee;
	}
	/**
	 * 获取：用户支付费用
	 */
	public String getUserPayFee() {
		return userPayFee;
	}
	/**
	 * 设置：运费
	 */
	public void setWayFee(String wayFee) {
		this.wayFee = wayFee;
	}
	/**
	 * 获取：运费
	 */
	public String getWayFee() {
		return wayFee;
	}
	/**
	 * 设置：包装费
	 */
	public void setPackFee(String packFee) {
		this.packFee = packFee;
	}
	/**
	 * 获取：包装费
	 */
	public String getPackFee() {
		return packFee;
	}
	/**
	 * 设置：优惠券ID
	 */
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	/**
	 * 获取：优惠券ID
	 */
	public String getCouponId() {
		return couponId;
	}
	/**
	 * 设置：折扣
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	/**
	 * 获取：折扣
	 */
	public String getDiscount() {
		return discount;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getWxName() {
		return wxName;
	}

	public void setWxName(String wxName) {
		this.wxName = wxName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getReceiveAddr() {
		return receiveAddr;
	}

	public void setReceiveAddr(String receiveAddr) {
		this.receiveAddr = receiveAddr;
	}

	public String getReceivePhone() {
		return receivePhone;
	}

	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public List<SrvOrderFood> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<SrvOrderFood> foodList) {
		this.foodList = foodList;
	}
}
