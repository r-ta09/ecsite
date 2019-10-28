package com.internousdev.ecsite.dto;

public class UserInfoDTO {

	private String userName;
	private String password;
	private String userId;
	private String id;
	private String date;

	public String getUserName(){
		return userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId=userId;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id=id;
	}

	public String getDate(){
		return date;
	}

	public void setDate(String date){
		this.date=date;
	}
}
