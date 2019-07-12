package xin.cymall.entity.wchart;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-12 15:14:54
 */
public class SrvUserAddr extends BaseWx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/****/
	private String userId;
	/****/
	private String receiveAddr;
	/****/
	private String lng;
	/****/
	private String lat;
	/**1选中0未�?�中**/
	private String defaultSelect;
	/****/
	private String receivePhone;
	/****/
	private String receiveName;


	/**
	 * 设置�?
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取�?
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置�?
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取�?
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置�?
	 */
	public void setReceiveAddr(String receiveAddr) {
		this.receiveAddr = receiveAddr;
	}
	/**
	 * 获取�?
	 */
	public String getReceiveAddr() {
		return receiveAddr;
	}
	/**
	 * 设置�?
	 */
	public void setLng(String lng) {
		this.lng = lng;
	}
	/**
	 * 获取�?
	 */
	public String getLng() {
		return lng;
	}
	/**
	 * 设置�?
	 */
	public void setLat(String lat) {
		this.lat = lat;
	}
	/**
	 * 获取�?
	 */
	public String getLat() {
		return lat;
	}
	/**
	 * 设置�?1选中0未�?�中
	 */
	public void setDefaultSelect(String defaultSelect) {
		this.defaultSelect = defaultSelect;
	}
	/**
	 * 获取�?1选中0未�?�中
	 */
	public String getDefaultSelect() {
		return defaultSelect;
	}
	/**
	 * 设置�?
	 */
	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}
	/**
	 * 获取�?
	 */
	public String getReceivePhone() {
		return receivePhone;
	}
	/**
	 * 设置�?
	 */
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	/**
	 * 获取�?
	 */
	public String getReceiveName() {
		return receiveName;
	}

}
