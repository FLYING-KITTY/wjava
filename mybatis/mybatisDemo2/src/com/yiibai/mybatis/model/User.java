package com.yiibai.mybatis.model;

public class User {
	private int userID;
	private String userName;
	private String userPhone;
	
	public User setUserID(int userID){
		this.userID = userID;
		return this;
	}
	
	public int getUserID(){
		return this.userID;
	}
	public User setUserName(String userName){
		this.userName = userName;
		return this;
	}
	
	public String getuserName(){
		return this.userName;
	}
	public User setUserPhone(String userPhone){
		this.userPhone = userPhone;
		return this;
	}
	
	public String getUserPhone(){
		return this.userPhone;
	}
}
