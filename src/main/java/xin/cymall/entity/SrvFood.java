package xin.cymall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-25 17:47:38
 */
public class SrvFood implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/****/
	private String name;
	/****/
	private String scale;
	/****/
	private String cal;
	/****/
	private String price;
	/**1早晨2午餐3晚餐 多选**/
	private String foodType;
	/**1冷2热**/
	private String hotCold;
	/****/
	private String chianId;
	/****/
	private String restaurantId;
	/**1是 0否**/
	private String isAllRestaurant;
	/****/
	private String remark;
	/**1启用0禁用**/
	private String status;
	/****/
	private String sysPrice;

	private String imagePath;

	private String[] imagePaths;

	private String useScope;

	private String[] useScopes;

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date updateTime;

	private String rid;
	private String rname;

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
	 * 设置：
	 */
	public void setScale(String scale) {
		this.scale = scale;
	}
	/**
	 * 获取：
	 */
	public String getScale() {
		return scale;
	}
	/**
	 * 设置：
	 */
	public void setCal(String cal) {
		this.cal = cal;
	}
	/**
	 * 获取：
	 */
	public String getCal() {
		return cal;
	}
	/**
	 * 设置：
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * 获取：
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * 设置：1早晨2午餐3晚餐 多选
	 */
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	/**
	 * 获取：1早晨2午餐3晚餐 多选
	 */
	public String getFoodType() {
		return foodType;
	}
	/**
	 * 设置：1冷2热
	 */
	public void setHotCold(String hotCold) {
		this.hotCold = hotCold;
	}
	/**
	 * 获取：1冷2热
	 */
	public String getHotCold() {
		return hotCold;
	}
	/**
	 * 设置：
	 */
	public void setChianId(String chianId) {
		this.chianId = chianId;
	}
	/**
	 * 获取：
	 */
	public String getChianId() {
		return chianId;
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
	 * 设置：1是 0否
	 */
	public void setIsAllRestaurant(String isAllRestaurant) {
		this.isAllRestaurant = isAllRestaurant;
	}
	/**
	 * 获取：1是 0否
	 */
	public String getIsAllRestaurant() {
		return isAllRestaurant;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：1启用0禁用
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：1启用0禁用
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setSysPrice(String sysPrice) {
		this.sysPrice = sysPrice;
	}
	/**
	 * 获取：
	 */
	public String getSysPrice() {
		return sysPrice;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String[] getImagePaths() {
		return imagePaths;
	}

	public void setImagePaths(String[] imagePaths) {
		this.imagePaths = imagePaths;
	}

	public String[] getUseScopes() {
		return useScopes;
	}

	public void setUseScopes(String[] useScopes) {
		this.useScopes = useScopes;
	}

	public String getUseScope() {
		return useScope;
	}

	public void setUseScope(String useScope) {
		this.useScope = useScope;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}
}
