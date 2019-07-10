package xin.cymall.entity.wchart;

/**
 * Created by Administrator on 2019/7/10.
 */
public class HealthOrderRequest {
    private String orderType; //订单类型
    private Integer cal; //热量
    private String userAddrId; //用户位置id

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getCal() {
        return cal;
    }

    public void setCal(Integer cal) {
        this.cal = cal;
    }

    public String getUserAddrId() {
        return userAddrId;
    }

    public void setUserAddrId(String userAddrId) {
        this.userAddrId = userAddrId;
    }
}
