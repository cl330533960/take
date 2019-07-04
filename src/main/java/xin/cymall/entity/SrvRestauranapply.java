package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-03 22:17:41
 */
public class SrvRestauranapply implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**主键ID**/
	private String id;
	/**申请人**/
	private String applicant;
	/**联系电话**/
	private String applyPhone;
	/**餐厅名**/
	private String restaurantName;
	/**地址**/
	private String addr;
	/**健康等级**/
	private String healthLevel;
	/**申请时间**/
	private Date applyTime;
	/**状态**/
	private String status;

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
	 * 设置：申请人
	 */
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	/**
	 * 获取：申请人
	 */
	public String getApplicant() {
		return applicant;
	}
	/**
	 * 设置：联系电话
	 */
	public void setApplyPhone(String applyPhone) {
		this.applyPhone = applyPhone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getApplyPhone() {
		return applyPhone;
	}
	/**
	 * 设置：餐厅名
	 */
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	/**
	 * 获取：餐厅名
	 */
	public String getRestaurantName() {
		return restaurantName;
	}
	/**
	 * 设置：地址
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * 获取：地址
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * 设置：健康等级
	 */
	public void setHealthLevel(String healthLevel) {
		this.healthLevel = healthLevel;
	}
	/**
	 * 获取：健康等级
	 */
	public String getHealthLevel() {
		return healthLevel;
	}
	/**
	 * 设置：申请时间
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getApplyTime() {
		return applyTime;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
}
