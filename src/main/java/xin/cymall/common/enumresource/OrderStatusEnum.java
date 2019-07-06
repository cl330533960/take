package xin.cymall.common.enumresource;

import xin.cymall.common.utils.EnumMessage;

/**
 * Created by Administrator on 2019/7/4.
 */
public enum OrderStatusEnum  implements EnumMessage {
    ORDRT_STATUS1("1","待支付"),
    ORDRT_STATUS2("2","待餐厅接单"),
    ORDRT_STATUS3("3","正在备餐"),
    ORDRT_STATUS4("4","待骑手取餐"),
    ORDRT_STATUS5("5","骑手正在向你飞奔"),
    ORDRT_STATUS6("6","已签收"),
    ORDRT_STATUS7("7","已取消"),
    ORDRT_STATUS8("8","餐厅拒接");

    private final String code;
    private final String value;
    private OrderStatusEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }



    @Override
    public String getCode() { return code;}
    @Override
    public String getValue() {
        return value;
    }

    public static String getValue(String code) {
        OrderStatusEnum[] businessModeEnums = values();
        for (OrderStatusEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.getCode().equals(code)) {
                return businessModeEnum.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getValue("1"));
    }

}
