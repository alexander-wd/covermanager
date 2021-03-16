package org.changli.covermanager.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="work_record")
public class Work_record {

	@Column(name="maintenanceID")
	private String maintenanceID;		//检修编号
	@Column(name="personID")
	private String personID;		//人员编号
	@Column(name="coverID")
	private String coverID;		//井盖编号
	@Column(name="start_time")
	private String start_time;		//开始时间
	@Column(name="end_time")
	private String end_time;		//完成时间
	@Column(name="log")
	private String log;		//工作日志，对工作内容的描述
	
	public String getMaintenanceID() {
		return maintenanceID;
	}
	public void setMaintenanceID(String maintenanceID) {
		this.maintenanceID = maintenanceID;
	}
	public String getPersonID() {
		return personID;
	}
	public void setPersonID(String personID) {
		this.personID = personID;
	}
	public String getCoverID() {
		return coverID;
	}
	public void setCoverID(String coverID) {
		this.coverID = coverID;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getLog() {
		return log;
	}
	public void setLog(String log) {
		this.log = log;
	}
	@Override
	public String toString() {
		return "Work_record [maintenanceID=" + maintenanceID + ", personID=" + personID + ", coverID=" + coverID
				+ ", start_time=" + start_time + ", end_time=" + end_time + ", log=" + log + "]";
	}
	
	/**
	 * 判断该人员位置对象是否符合基本情况,用于添加和修改的检验
	 * 
	 * @return
	 */
	public boolean isValid() {
		return true;
	}
	
}
