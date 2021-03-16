package org.changli.covermanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * 井盖
 * @author admin
 */
@Entity
@Table(name="cover")
public class Cover {

	@Column(name="coverID")
	private String coverID;		//每个井盖独有编号
	@Column(name="longitude")
	private double longitude;		//经度，东经正数，西经为负数
	@Column(name="latitude")
	private double latitude;		//纬度，以北纬为正，南纬为负数
	@Column(name="height")
	private double height;		//液面到井盖的距离
	@Column(name="temperature")
	private double temperature;		//温度，定制功能可空
	@Column(name="humidity")
	private double humidity;		//湿度，定制功能可空(小数，湿度在0-1之间)
	@Column(name="daily_traffic")
	private int daily_traffic;		//日车流量，定制功能可空，每日刷新一次
	
	public String getCoverID() {
		return coverID;
	}
	public void setCoverID(String coverID) {
		this.coverID = coverID;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public int getDaily_traffic() {
		return daily_traffic;
	}
	public void setDaily_traffic(int daily_traffic) {
		this.daily_traffic = daily_traffic;
	}
	@Override
	public String toString() {
		return "Cover [coverID=" + coverID + ", longitude=" + longitude + ", latitude=" + latitude + ", height="
				+ height + ", temperature=" + temperature + ", humidity=" + humidity + ", daily_traffic="
				+ daily_traffic + "]";
	}
	
	/**
	 * 判断该井盖对象是否符合基本情况,用于添加和修改的检验
	 * @return 
	 */
	public boolean isValid() {
		if(longitude<-180 || longitude>180) {	//经度在东西经180°以内
			return false;
		}
		if(latitude<-90 || latitude>90) {		//维度在南北纬90°以内
			return false;
		}
		if(humidity<0 || humidity>1) {		//湿度在0和1之间
			return false;
		}
		return true;
	}
	
}
