package xin.cymall.entity.wchart;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-12 15:25:58
 */
public class SrvWxUser extends BaseWx implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/****/
	/****/
	private String phone;
	/****/
	/****/
	private String sex;
	/****/
	private String height;
	/****/
	private String weight;
	/****/
	private Date useDate;
	/****/
	private String bodyMassIndex;
	/****/
	private String shape;
	/****/
	private String centralObesity;

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
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：
	 */
	public String getPhone() {
		return phone;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：
	 */
	public void setHeight(String height) {
		this.height = height;
	}
	/**
	 * 获取：
	 */
	public String getHeight() {
		return height;
	}
	/**
	 * 设置：
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
	/**
	 * 获取：
	 */
	public String getWeight() {
		return weight;
	}
	/**
	 * 设置：
	 */
	public void setUseDate(Date useDate) {
		this.useDate = useDate;
	}
	/**
	 * 获取：
	 */
	public Date getUseDate() {
		return useDate;
	}
	/**
	 * 设置：
	 */
	public void setBodyMassIndex(String bodyMassIndex) {
		this.bodyMassIndex = bodyMassIndex;
	}
	/**
	 * 获取：
	 */
	public String getBodyMassIndex() {
		return bodyMassIndex;
	}
	/**
	 * 设置：
	 */
	public void setShape(String shape) {
		this.shape = shape;
	}
	/**
	 * 获取：
	 */
	public String getShape() {
		return shape;
	}
	/**
	 * 设置：
	 */
	public void setCentralObesity(String centralObesity) {
		this.centralObesity = centralObesity;
	}
	/**
	 * 获取：
	 */
	public String getCentralObesity() {
		return centralObesity;
	}
}
