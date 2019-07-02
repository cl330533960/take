package xin.cymall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-26 18:38:42
 */
public class SrvMerchanclear implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**主键ID**/
	private String id;
	/**商家ID**/
	private String restaurantId;
	/**余额**/
	private Double clearAmount;
	/**上次结余**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date clearTime;
	/**操作人**/
	private String optrName;

	/**
	 * 设置：主键ID
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：商家ID
	 */
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	/**
	 * 获取：商家ID
	 */
	public String getRestaurantId() {
		return restaurantId;
	}
	/**
	 * 设置：余额
	 */
	public void setClearAmount(Double clearAmount) {
		this.clearAmount = clearAmount;
	}
	/**
	 * 获取：余额
	 */
	public Double getClearAmount() {
		return clearAmount;
	}
	/**
	 * 设置：上次结余
	 */
	public void setClearTime(Date clearTime) {
		this.clearTime = clearTime;
	}
	/**
	 * 获取：上次结余
	 */
	public Date getClearTime() {
		return clearTime;
	}
	/**
	 * 设置：操作人
	 */
	public void setOptrName(String optrName) {
		this.optrName = optrName;
	}
	/**
	 * 获取：操作人
	 */
	public String getOptrName() {
		return optrName;
	}
}
