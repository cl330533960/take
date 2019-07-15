package xin.cymall.common.dadaexpress.domain.merchant;

import com.alibaba.fastjson.annotation.JSONField;
import xin.cymall.common.dadaexpress.domain.BaseModel;

/**@date 2019/07/15
 */
public class MerchantAddModel extends BaseModel {

    private String mobile;

    @JSONField(name = "city_name")
    private String cityName;

    @JSONField(name = "enterprise_name")
    private String enterpriseName;

    @JSONField(name = "enterprise_name")
    private String enterpriseAddress;

    @JSONField(name = "enterprise_name")
    private String contactName;

    @JSONField(name = "enterprise_name")
    private String contactPhone;

    private String email;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
