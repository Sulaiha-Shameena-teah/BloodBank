package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SaveBlood
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blood_donor_id;
	private String username; 
	private int userid;
	private String mobilenumber;
	private String bloodgroup;
	private String date;
	private String disease;
	private String status; 
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public int getBlood_donor_id() {
		return blood_donor_id;
	}
	public void setBlood_donor_id(int blood_donor_id) {
		this.blood_donor_id = blood_donor_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	@Override
	public String toString() {
		return "SaveBlood [blood_donor_id=" + blood_donor_id + ", username=" + username + ", userid=" + userid
				+ ", mobilenumber=" + mobilenumber + ", bloodgroup=" + bloodgroup + ", date=" + date + ", disease="
				+ disease + "]";
	}
	
	
	
	
	
	
}
