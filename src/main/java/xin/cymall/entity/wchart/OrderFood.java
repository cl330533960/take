package xin.cymall.entity.wchart;

import java.io.Serializable;

/**
 * @ClassName OrderFood
 * @Author cailei
 * @Description
 * @Date 2019/7/12 16:04
 **/
public class OrderFood  implements Serializable {
    private String id;
    private String fudId;
    private String name;
    private String rid;
    private Double sysPrice;
    private Double packFee;
    private Integer number;
    private Double totalPrice;
    private Double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFudId() {
        return fudId;
    }

    public void setFudId(String fudId) {
        this.fudId = fudId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Double getSysPrice() {
        return sysPrice;
    }

    public void setSysPrice(Double sysPrice) {
        this.sysPrice = sysPrice;
    }

    public Double getPackFee() {
        return packFee;
    }

    public void setPackFee(Double packFee) {
        this.packFee = packFee;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderFood orderFood = (OrderFood) o;

        if (!fudId.equals(orderFood.fudId)) return false;
        if (!name.equals(orderFood.name)) return false;
        if (!rid.equals(orderFood.rid)) return false;
        if (!sysPrice.equals(orderFood.sysPrice)) return false;
        return price.equals(orderFood.price);

    }

    @Override
    public int hashCode() {
        int result = fudId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + rid.hashCode();
        result = 31 * result + sysPrice.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
