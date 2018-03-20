package com.mybatis.model;

public class Users {
	private int userID;
	private String userName;
	private String userPhone;
	
	public Users setUserID(int userID){
		this.userID = userID;
		return this;
	}
	
	public int getUserID(){
		return this.userID;
	}
	public Users setUserName(String userName){
		this.userName = userName;
		return this;
	}
	
	public String getuserName(){
		return this.userName;
	}
	public Users setUserPhone(String userPhone){
		this.userPhone = userPhone;
		return this;
	}
	
	public String getUserPhone(){
		return this.userPhone;
	}
}
