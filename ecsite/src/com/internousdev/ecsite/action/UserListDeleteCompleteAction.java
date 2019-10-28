package com.internousdev.ecsite.action;

import java.util.ArrayList;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{

	private ArrayList<UserInfoDTO> userList=new ArrayList<UserInfoDTO>();
	private String message;

	public String execute() throws Exception{
		UserListDeleteCompleteDAO dao=new UserListDeleteCompleteDAO();
		int res=dao.userListDelete();

		if(res>0){
			userList=null;
			setMessage("ユーザー情報が正しく削除されました。");
		}else if(res==0){
			setMessage("ユーザー情報が正しく削除されませんでした。");
		}

		String ret=SUCCESS;
		return ret;
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message=message;
	}

	public ArrayList<UserInfoDTO> getUserList(){
		return userList;
	}

	public void setUserList(ArrayList<UserInfoDTO> userList){
		this.userList=userList;
	}
}
