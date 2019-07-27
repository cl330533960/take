package xin.cymall.common.dadaexpress.domain.order;

import com.alibaba.fastjson.annotation.JSONField;
import xin.cymall.common.dadaexpress.domain.BaseModel;

import java.math.BigDecimal;

/**@date 2019/07/15
 */
public class OrderQueryModel extends BaseModel {

    @JSONField(name = "order_id")
    private String orderID;

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
}
