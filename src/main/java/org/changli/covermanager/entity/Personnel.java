package org.changli.covermanager.entity;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 人员基本信息类
 * 
 * @author admin
 */
@Entity
@Table(name="personnel")
public class Personnel {

	@Column(name="personID")
	private String personID; // 人员编号
	@Column(name="name")
	private String name; // 姓名
	@Column(name="work_status")
	private String work_status; // 上班状态，分为”空闲”，”休息”，”忙碌中”，”下班”
	@Column(name="operation_number")
	private int operation_number; // 累计作业次数，每月刷新一次
	@Column(name="img")
	private byte[] img; // 上传图片
	@Column(name="workID")
	private String workID; // 工作对象ID
	@Column(name="phone")
	private String phone; // 电话

	public String getPersonID() {
		return personID;
	}

	public void setPersonID(String personID) {
		this.personID = personID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWork_status() {
		return work_status;
	}

	public void setWork_status(String work_status) {
		this.work_status = work_status;
	}

	public int getOperation_number() {
		return operation_number;
	}

	public void setOperation_number(int operation_number) {
		this.operation_number = operation_number;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public String getWorkID() {
		return workID;
	}

	public void setWorkID(String workID) {
		this.workID = workID;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Personnel [personID=" + personID + ", name=" + name + ", work_status=" + work_status
				+ ", operation_number=" + operation_number + ", img=" + Arrays.toString(img) + ", workID=" + workID
				+ ", phone=" + phone + "]";
	}

	/**
	 * 判断该人员信息对象是否符合基本情况,用于添加和修改的检验
	 * 
	 * @return
	 */
	public boolean isValid() {
		try {
			String str = URLDecoder.decode(work_status, "UTF-8");
			if (!(str.equals("空闲") || str.equals("休息") || str.equals("忙碌中")
					|| str.equals("下班"))) { // 上班状态，分为”空闲”，”休息”，”忙碌中”，”下班”
				return false;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		if (!(work_status.equals("空闲") || work_status.equals("休息") || work_status.equals("忙碌中")
//				|| work_status.equals("下班"))) { // 上班状态，分为”空闲”，”休息”，”忙碌中”，”下班”
//			return false;
//		}
		String regExp = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])" + "|(18[0-9])|(19[8,9]))\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(phone);
		if (!m.matches()) { // 维度在南北纬90°以内
			return false;
		}
		return true;
	}

}
