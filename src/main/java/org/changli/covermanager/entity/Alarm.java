package org.changli.covermanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 报警信息
 * @author admin
 */
@Entity
@Table(name="alarm")
public class Alarm{

	@Column(name="coverID")
	private String coverID;		//井盖编号
	@Column(name="alarm_information")
	private int alarm_information;		//报警信息，每位二进制数代表一种报警信息，从左到右为：”井盖非正常移动报警”，”井盖非正常翻动报警”，”液面高度报警”，”液面上涨速度报警”，”温度报警”，”装置报警”，如：若报警信息为3=000110代表液面上涨过快报警和温度报警
	@Column(name="current")
	private String current;		//时间
	
	public String getCoverID() {
		return coverID;
	}
	public void setCoverID(String coverID) {
		this.coverID = coverID;
	}
	public int getAlarm_information() {
		return alarm_information;
	}
	public void setAlarm_information(int alarm_information) {
		this.alarm_information = alarm_information;
	}
	public String getCurrent_time() {
		return current;
	}
	public void setCurrent_time(String current_time) {
		this.current = current_time;
	}
	@Override
	public String toString() {
		return "Alarm [coverID=" + coverID + ", alarm_information=" + alarm_information + ", current_time="
				+ current + "]";
	}
	
	/**
	 * 判断该警报对象是否符合基本情况,用于添加和修改的检验
	 * @return 
	 */
	public boolean isValid() {
		if(alarm_information<0 || alarm_information>63) { 	//	报警信息的编码在0到63之间
			return false;
		}
		return true;
	}
	
}
