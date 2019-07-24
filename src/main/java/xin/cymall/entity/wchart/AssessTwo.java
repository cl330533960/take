package xin.cymall.entity.wchart;

/**
 * Created by Administrator on 2019/7/6.
 */
public class AssessTwo extends BaseWx{

    /**体重*/
    private Double weight;

    /**性别*/
    private String sex;
    private Double waistline;


    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWaistline() {
        return waistline;
    }

    public void setWaistline(Double waistline) {
        this.waistline = waistline;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
