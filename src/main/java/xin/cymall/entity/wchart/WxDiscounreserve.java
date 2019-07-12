package xin.cymall.entity.wchart;

/**
 * @ClassName WxYd
 * @Author cailei
 * @Description
 * @Date 2019/7/12 16:46
 **/
public class WxDiscounreserve extends BaseWx {
    private String discounType; //1周 2月
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDiscounType() {
        return discounType;
    }

    public void setDiscounType(String discounType) {
        this.discounType = discounType;
    }
}
