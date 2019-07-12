package xin.cymall.entity.wchart;

/**
 * @ClassName OrderFood
 * @Author cailei
 * @Description
 * @Date 2019/7/12 16:04
 **/
public class OrderFood {
    private String foodId;
    private String foodName;
    private Double price;
    private Integer number;
    private Double totalPrice;

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
