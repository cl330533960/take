package xin.cymall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Timer;


/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-06-21 18:55:54
 */
public class SrvRestaurant implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/****/
	private String name;
	/****/
	private String chainCode;
	/****/
	private String province;
	/****/
	private String city;
	/****/
	private String area;
	/****/
	private String addr;
	/****/
	private String healthLevel;
	/****/
	private String contact;
	/****/
	private String phone;
	/****/
	private String landline;
	/****/
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date inTime;
	/****/
	private String logoPath;
	/****/
	private String busLicense;
	/****/
	private String hygieneLicensePath;
	/**1营业 0歇业**/
	private String status;
	/****/
	private String remark;
	/****/
	private String loginName;
	/****/
	private String password;
	/****/
	private Double balance;
	/**1自动0手动**/
	private String autoReceipt;
	/****/
	private String packFee;
	/****/
	@DateTimeFormat(pattern="HH:mm")
	private Date busHourStart;
	/****/
	@DateTimeFormat(pattern="HH:mm")
	private Date busHourEnd;
	/**1�?0�?**/
	private String isAllDay;
	/****/
	private String lng;
	/****/
	private String lat;

	private String clientId;

	private String[] parentAreaIds;

	private String username;

	private List<Long> roleIdList;

	private Long userId;

	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date lastTime; //最近结算时间，用于显示

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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取�?
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置�?
	 */
	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}
	/**
	 * 获取�?
	 */
	public String getChainCode() {
		return chainCode;
	}
	/**
	 * 设置�?
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取�?
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置�?
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取�?
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置�?
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取�?
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置�?
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * 获取�?
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * 设置�?
	 */
	public void setHealthLevel(String healthLevel) {
		this.healthLevel = healthLevel;
	}
	/**
	 * 获取�?
	 */
	public String getHealthLevel() {
		return healthLevel;
	}
	/**
	 * 设置�?
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取�?
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置�?
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取�?
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置�?
	 */
	public void setLandline(String landline) {
		this.landline = landline;
	}
	/**
	 * 获取�?
	 */
	public String getLandline() {
		return landline;
	}
	/**
	 * 设置�?
	 */
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	/**
	 * 获取�?
	 */
	public Date getInTime() {
		return inTime;
	}
	/**
	 * 设置�?
	 */
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	/**
	 * 获取�?
	 */
	public String getLogoPath() {
		return logoPath;
	}
	/**
	 * 设置�?
	 */
	public void setBusLicense(String busLicense) {
		this.busLicense = busLicense;
	}
	/**
	 * 获取�?
	 */
	public String getBusLicense() {
		return busLicense;
	}
	/**
	 * 设置�?
	 */
	public void setHygieneLicensePath(String hygieneLicensePath) {
		this.hygieneLicensePath = hygieneLicensePath;
	}
	/**
	 * 获取�?
	 */
	public String getHygieneLicensePath() {
		return hygieneLicensePath;
	}
	/**
	 * 设置�?1营业 0歇业
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取�?1营业 0歇业
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置�?
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取�?
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置�?
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * 获取�?
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * 设置�?
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取�?
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置�?
	 */
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	/**
	 * 获取�?
	 */
	public Double getBalance() {
		return balance;
	}
	/**
	 * 设置�?1自动0手动
	 */
	public void setAutoReceipt(String autoReceipt) {
		this.autoReceipt = autoReceipt;
	}
	/**
	 * 获取�?1自动0手动
	 */
	public String getAutoReceipt() {
		return autoReceipt;
	}
	/**
	 * 设置�?
	 */
	public void setPackFee(String packFee) {
		this.packFee = packFee;
	}
	/**
	 * 获取�?
	 */
	public String getPackFee() {
		return packFee;
	}
	/**
	 * 设置�?
	 */
	public void setBusHourStart(Date busHourStart) {
		this.busHourStart = busHourStart;
	}
	/**
	 * 获取�?
	 */
	public Date getBusHourStart() {
		return busHourStart;
	}
	/**
	 * 设置�?
	 */
	public void setBusHourEnd(Date busHourEnd) {
		this.busHourEnd = busHourEnd;
	}
	/**
	 * 获取�?
	 */
	public Date getBusHourEnd() {
		return busHourEnd;
	}
	/**
	 * 设置�?1�?0�?
	 */
	public void setIsAllDay(String isAllDay) {
		this.isAllDay = isAllDay;
	}
	/**
	 * 获取�?1�?0�?
	 */
	public String getIsAllDay() {
		return isAllDay;
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String[] getParentAreaIds() {
		return parentAreaIds;
	}

	public void setParentAreaIds(String[] parentAreaIds) {
		this.parentAreaIds = parentAreaIds;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}
