package xin.cymall.entity.wchart;

import xin.cymall.entity.SrvFood;

import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */
public class WxOrder {
    private String restaurantId;
    private List<SrvFood> foodList;
    private String orderType;
    private String wxId;
    private String remark;
    /**运费**/
    private Integer wayFee;
    /**包装费**/
    private Integer packFee;
    /**优惠券ID**/
    private String couponId;
    /**折扣**/
    private double discount;

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<SrvFood> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<SrvFood> foodList) {
        this.foodList = foodList;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
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
}
