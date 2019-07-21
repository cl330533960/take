package xin.cymall.entity.wchart;

import xin.cymall.entity.SrvFood;

import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */
public class WxOrder extends BaseWx {
    private String restaurantId;
    private String foodList;
    private String orderType;
    private String remark;
    private String userAddrId;
    /**运费**/
    private Integer wayFee;
    /**包装费**/
    private Integer packFee;
    /**优惠券ID**/
    private String couponId;
    /**折扣**/
    private double discount;
    /**订单总金额*/
    private Double totalAmount;
    /**用户支付金额*/
    private Double userPayAmount;
    /**餐厅订单总额*/
    private Double restaurantTotal;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getFoodList() {
        return foodList;
    }

    public void setFoodList(String foodList) {
        this.foodList = foodList;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getWayFee() {
        return wayFee;
    }

    public void setWayFee(Integer wayFee) {
        this.wayFee = wayFee;
    }

    public Integer getPackFee() {
        return packFee;
    }

    public void setPackFee(Integer packFee) {
        this.packFee = packFee;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getUserPayAmount() {
        return userPayAmount;
    }

    public void setUserPayAmount(Double userPayAmount) {
        this.userPayAmount = userPayAmount;
    }

    public String getUserAddrId() {
        return userAddrId;
    }

    public void setUserAddrId(String userAddrId) {
        this.userAddrId = userAddrId;
    }

    public Double getRestaurantTotal() {
        return restaurantTotal;
    }

    public void setRestaurantTotal(Double restaurantTotal) {
        this.restaurantTotal = restaurantTotal;
    }
}
