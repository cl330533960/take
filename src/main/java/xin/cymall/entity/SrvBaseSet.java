package xin.cymall.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chenyi
 * @email 228112142@qq.com
 * @date 2019-07-01 21:09:34
 */
public class SrvBaseSet implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/****/
	private String id;
	/**BMI计算公式**/
	private String bmi;
	/**偏瘦**/
	private String thin;
	/**正常**/
	private String normal;
	/**偏胖**/
	private String overWeight;
	/**肥胖**/
	private String obesity;
	/**正常体重上限**/
	private String normalWeightUp;
	/**正常体重下限**/
	private String normalWeightDown;
	/**男性BEE**/
	private String manBee;
	/**女性BEE**/
	private String woman;
	/****/
	private String sportRatio;
	/****/
	private String overWeightHeatDown;
	/****/
	private String overWeightHeatUp;
	/****/
	private String obesityHeatDown;
	/****/
	private String obesityHeatUp;

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
	 * 设置：BMI计算公式
	 */
	public void setBmi(String bmi) {
		this.bmi = bmi;
	}
	/**
	 * 获取：BMI计算公式
	 */
	public String getBmi() {
		return bmi;
	}
	/**
	 * 设置：偏瘦
	 */
	public void setThin(String thin) {
		this.thin = thin;
	}
	/**
	 * 获取：偏瘦
	 */
	public String getThin() {
		return thin;
	}
	/**
	 * 设置：正常
	 */
	public void setNormal(String normal) {
		this.normal = normal;
	}
	/**
	 * 获取：正常
	 */
	public String getNormal() {
		return normal;
	}
	/**
	 * 设置：偏胖
	 */
	public void setOverWeight(String overWeight) {
		this.overWeight = overWeight;
	}
	/**
	 * 获取：偏胖
	 */
	public String getOverWeight() {
		return overWeight;
	}
	/**
	 * 设置：肥胖
	 */
	public void setObesity(String obesity) {
		this.obesity = obesity;
	}
	/**
	 * 获取：肥胖
	 */
	public String getObesity() {
		return obesity;
	}
	/**
	 * 设置：正常体重上限
	 */
	public void setNormalWeightUp(String normalWeightUp) {
		this.normalWeightUp = normalWeightUp;
	}
	/**
	 * 获取：正常体重上限
	 */
	public String getNormalWeightUp() {
		return normalWeightUp;
	}
	/**
	 * 设置：正常体重下限
	 */
	public void setNormalWeightDown(String normalWeightDown) {
		this.normalWeightDown = normalWeightDown;
	}
	/**
	 * 获取：正常体重下限
	 */
	public String getNormalWeightDown() {
		return normalWeightDown;
	}
	/**
	 * 设置：男性BEE
	 */
	public void setManBee(String manBee) {
		this.manBee = manBee;
	}
	/**
	 * 获取：男性BEE
	 */
	public String getManBee() {
		return manBee;
	}
	/**
	 * 设置：女性BEE
	 */
	public void setWoman(String woman) {
		this.woman = woman;
	}
	/**
	 * 获取：女性BEE
	 */
	public String getWoman() {
		return woman;
	}
	/**
	 * 设置：
	 */
	public void setSportRatio(String sportRatio) {
		this.sportRatio = sportRatio;
	}
	/**
	 * 获取：
	 */
	public String getSportRatio() {
		return sportRatio;
	}
	/**
	 * 设置：
	 */
	public void setOverWeightHeatDown(String overWeightHeatDown) {
		this.overWeightHeatDown = overWeightHeatDown;
	}
	/**
	 * 获取：
	 */
	public String getOverWeightHeatDown() {
		return overWeightHeatDown;
	}
	/**
	 * 设置：
	 */
	public void setOverWeightHeatUp(String overWeightHeatUp) {
		this.overWeightHeatUp = overWeightHeatUp;
	}
	/**
	 * 获取：
	 */
	public String getOverWeightHeatUp() {
		return overWeightHeatUp;
	}
	/**
	 * 设置：
	 */
	public void setObesityHeatDown(String obesityHeatDown) {
		this.obesityHeatDown = obesityHeatDown;
	}
	/**
	 * 获取：
	 */
	public String getObesityHeatDown() {
		return obesityHeatDown;
	}
	/**
	 * 设置：
	 */
	public void setObesityHeatUp(String obesityHeatUp) {
		this.obesityHeatUp = obesityHeatUp;
	}
	/**
	 * 获取：
	 */
	public String getObesityHeatUp() {
		return obesityHeatUp;
	}
}
