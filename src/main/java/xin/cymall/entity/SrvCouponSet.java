package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-27 22:18:33
 */
public class SrvCouponSet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/**金额**/
	private String amount;
	/**有效期**/
	private String validDay;
	/**类型**/
	private String type;
	/**1打开0关闭**/
	private String openClose;

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
	 * 设置：金额
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * 获取：金额
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * 设置：有效期
	 */
	public void setValidDay(String validDay) {
		this.validDay = validDay;
	}
	/**
	 * 获取：有效期
	 */
	public String getValidDay() {
		return validDay;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：1打开0关闭
	 */
	public void setOpenClose(String openClose) {
		this.openClose = openClose;
	}
	/**
	 * 获取：1打开0关闭
	 */
	public String getOpenClose() {
		return openClose;
	}
}
