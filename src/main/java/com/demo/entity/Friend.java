package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Friend {

	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Mobile_Number")
	private long mobileNum;

	@Column(name = "College_Name")
	private String college;

	public Friend() {
		super();
	}

	public Friend(String id, String name, long mobileNum, String college) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNum = mobileNum;
		this.college = college;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", name=" + name + ", mobileNum=" + mobileNum + ", college=" + college + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

}
