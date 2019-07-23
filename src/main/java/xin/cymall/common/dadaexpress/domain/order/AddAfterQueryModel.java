package xin.cymall.common.dadaexpress.domain.order;

import com.alibaba.fastjson.annotation.JSONField;
import xin.cymall.common.dadaexpress.domain.BaseModel;

import java.math.BigDecimal;

/**@date 2019/07/15
 */
public class AddAfterQueryModel extends BaseModel {

    @JSONField(name = "deliveryNo")
    private String deliveryNo;

    public String getDeliveryNo() {
        return deliveryNo;
    }

    public void setDeliveryNo(String deliveryNo) {
        this.deliveryNo = deliveryNo;
    }
}
