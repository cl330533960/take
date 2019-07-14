package xin.cymall.common.enumresource;

import xin.cymall.common.utils.EnumMessage;

/**
 * Created by Administrator on 2019/7/14.
 */
public enum CouponTypeEnum implements EnumMessage {
    ORDRT_TYPE1("1","外卖券"),
    ORDRT_TYPE2("2","打包券"),
    ORDRT_TYPE3("3","就餐券");

    private final String code;
    private final String value;
    private CouponTypeEnum(String code, String value) {
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
        CouponTypeEnum[] businessModeEnums = values();
        for (CouponTypeEnum businessModeEnum : businessModeEnums) {
            if (businessModeEnum.getCode().equals(code)) {
                return businessModeEnum.getValue();
            }
        }
        return null;
    }

}
