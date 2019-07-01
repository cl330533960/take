package xin.cymall.common.enumresource;

import xin.cymall.common.utils.EnumMessage;

/**
 * Created by Administrator on 2019/7/1.
 */
public enum SportRatioEnum implements EnumMessage {
    LESS("1","1.1=很少运动"),
    COMMONLY("2","1.15=每周走步2-3次，每次40分钟以上"),
    MANY("3","1.2=每周慢跑3次以上，每次40分钟以上");
    private final String code;
    private final String value;
    private SportRatioEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
    @Override
    public String getCode() { return code;}
    @Override
    public String getValue() { return value; }
}
