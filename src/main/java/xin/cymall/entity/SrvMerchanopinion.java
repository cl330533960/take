package xin.cymall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-24 11:52:55
 */
public class SrvMerchanopinion implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/****/
	private String restaurantId;
	/****/
	private String content;
	/****/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date commentTime;
	/****/
	private String name;
	/**0待审核 1审核通过 2审核拒绝**/
	private String status;
	/****/
	private String phone;

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
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	/**
	 * 获取：
	 */
	public String getRestaurantId() {
		return restaurantId;
	}
	/**
	 * 设置：
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}
	/**
	 * 获取：
	 */
	public Date getCommentTime() {
		return commentTime;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：0待审核 1审核通过 2审核拒绝
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：0待审核 1审核通过 2审核拒绝
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}
}
