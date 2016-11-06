package com.org.patient.model;

import java.util.Date;

public class Patient {
	
	
	private String first_name;
	private String last_name;
	private long dob;
	private int age;
	private String gender;
	private String info;
	private String phone;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public long getDob() {
		return dob;
	}
	public void setDob(long dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Patient [first_name=" + first_name + ", last_name=" + last_name
				+ ", dob=" + dob + ", age=" + age + ", gender=" + gender
				+ ", info=" + info + ", phone=" + phone + "]";
	}
	
	
	
}
