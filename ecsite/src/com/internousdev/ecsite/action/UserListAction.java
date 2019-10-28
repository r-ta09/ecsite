package com.internousdev.ecsite.action;

import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport{

	private ArrayList<UserInfoDTO> userList=new ArrayList<UserInfoDTO>();

	public String execute() throws Exception{
		String ret=SUCCESS;


		UserListDAO dao=new UserListDAO();

		userList=dao.getAllUsers();

		return ret;

	}

	public ArrayList<UserInfoDTO> getUserList(){
		return userList;
	}

	public void setUserList(ArrayList<UserInfoDTO> userList){
		this.userList=userList;
	}
}
