package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-05 23:30:59
 */
public class SrvFoodUpDown implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/****/
	private String foodId;
	/****/
	private String restaurantId;

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
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	/**
	 * 获取：
	 */
	public String getRestaurantId() {
		return restaurantId;
	}
}
