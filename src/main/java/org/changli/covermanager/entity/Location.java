package org.changli.covermanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 人员位置信息类
 * @author admin
 */
@Entity
@Table(name="location")
public class Location {

	@Column(name="personID")
	private String personID;		//人员编号
	@Column(name="longitude")
	private double longitude;		//经度
	@Column(name="latitude")
	private double latitude;		//纬度
	
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(String personID) {
		this.personID = personID;
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
	@Override
	public String toString() {
		return "Location [personID=" + personID + ", longitude=" + longitude + ", latitude=" + latitude + "]";
	}
	
	/**
	 * 判断该人员位置对象是否符合基本情况,用于添加和修改的检验
	 * @return 
	 */
	public boolean isValid() {
		if(longitude<-180 || longitude>180) {	//经度在东西经180°以内
			return false;
		}
		if(latitude<-90 || latitude>90) {		//维度在南北纬90°以内
			return false;
		}
		return true;
	}
	
}
