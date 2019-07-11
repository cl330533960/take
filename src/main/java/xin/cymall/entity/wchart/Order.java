package xin.cymall.entity.wchart;

import xin.cymall.entity.SrvFood;

import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */
public class Order {
    private String restaurantId;
    private List<SrvFood> foodList;
    private String orderType;
    private String wxId;
    private String remark;
}
