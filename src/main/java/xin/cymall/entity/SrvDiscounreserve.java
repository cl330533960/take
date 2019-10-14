package xin.cymall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-25 17:24:03
 */
public class SrvDiscounreserve implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/**折扣开始时间**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date discountStart;
	/**折扣结束时间**/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date discountEnd;
	/**状态**/
	private String status;
	/**用户ID**/
	private String userId;
	/**折扣比**/
	private Double discount;

	private String remark;

	private String wxName;

	private String type; //套餐類型 1周套餐 2月套餐

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
	 * 设置：折扣开始时间
	 */
	public void setDiscountStart(Date discountStart) {
		this.discountStart = discountStart;
	}
	/**
	 * 获取：折扣开始时间
	 */
	public Date getDiscountStart() {
		return discountStart;
	}
	/**
	 * 设置：折扣结束时间
	 */
	public void setDiscountEnd(Date discountEnd) {
		this.discountEnd = discountEnd;
	}
	/**
	 * 获取：折扣结束时间
	 */
	public Date getDiscountEnd() {
		return discountEnd;
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
	/**
	 * 设置：用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：折扣比
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	/**
	 * 获取：折扣比
	 */
	public Double getDiscount() {
		return discount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getWxName() {
		return wxName;
	}

	public void setWxName(String wxName) {
		this.wxName = wxName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
