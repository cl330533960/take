package xin.cymall.entity.wchart;

/**
 * Created by Administrator on 2019/7/6.
 */
public class AssessOne {
    /**身高*/
    private Double height;
    /**体重*/
    private Double weight;
    /**性别*/
    private String sex;

    private Integer age;

    private Double waistline;

    private Double sportRatio;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getWaistline() {
        return waistline;
    }

    public void setWaistline(Double waistline) {
        this.waistline = waistline;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSportRatio() {
        return sportRatio;
    }

    public void setSportRatio(Double sportRatio) {
        this.sportRatio = sportRatio;
    }
}
