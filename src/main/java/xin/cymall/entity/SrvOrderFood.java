package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-28 14:55:15
 */
public class SrvOrderFood implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/****/
	private String foodId;
	/****/
	private String number;
	/****/
	private String totalPrice;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	/**
	 * 获取：
	 */
	public String getFoodId() {
		return foodId;
	}
	/**
	 * 设置：
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * 获取：
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * 设置：
	 */
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * 获取：
	 */
	public String getTotalPrice() {
		return totalPrice;
	}
}
