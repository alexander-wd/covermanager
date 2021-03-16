package org.changli.covermanager.entity;

import javax.persistence.Column;

public class MapResult {

	private String coverID;		//每个井盖独有编号
	private double longitude;		//经度，东经正数，西经为负数
	private double latitude;		//纬度，以北纬为正，南纬为负数
	private double height;		//液面到井盖的距离
	private double temperature;		//温度，定制功能可空
	private double humidity;		//湿度，定制功能可空(小数，湿度在0-1之间)
	private int daily_traffic;		//日车流量，定制功能可空，每日刷新一次
	private int alarm_information;		//报警信息，每位二进制数代表一种报警信息，从左到右为：”井盖非正常移动报警”，”井盖非正常翻动报警”，”液面高度报警”，”液面上涨速度报警”，”温度报警”，”装置报警”，如：若报警信息为3=000110代表液面上涨过快报警和温度报警
	private String current;		//时间
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
	public int getAlarm_information() {
		return alarm_information;
	}
	public void setAlarm_information(int alarm_information) {
		this.alarm_information = alarm_information;
	}
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	@Override
	public String toString() {
		return "MapResult [coverID=" + coverID + ", longitude=" + longitude + ", latitude=" + latitude + ", height="
				+ height + ", temperature=" + temperature + ", humidity=" + humidity + ", daily_traffic="
				+ daily_traffic + ", alarm_information=" + alarm_information + ", current=" + current + "]";
	}
	public MapResult(String coverID, double longitude, double latitude, double height, double temperature,
			double humidity, int daily_traffic, int alarm_information, String current) {
		super();
		this.coverID = coverID;
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
		this.temperature = temperature;
		this.humidity = humidity;
		this.daily_traffic = daily_traffic;
		this.alarm_information = alarm_information;
		this.current = current;
	}
	
	public MapResult() {
		super();
	}
	
	
	
	
}
