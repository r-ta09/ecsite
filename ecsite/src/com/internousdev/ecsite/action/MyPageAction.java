package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private MyPageDAO dao=new MyPageDAO();
	private ArrayList<MyPageDTO> myList=new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws Exception{
		if(!session.containsKey("login_user_id")){
			return ERROR;
		}

		if(deleteFlg==null){
			String item_transaction_id=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();

			myList=dao.getMyPageUserInfo(item_transaction_id,user_master_id);




		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}

	public void delete() throws Exception{
		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();

		int res=dao.buyItemHistoryDelete(item_transaction_id,user_master_id);

		if(res>0){
			myList=null;
			setMessage("商品情報を正しく削除しました。");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<MyPageDTO> getMyList(){
		return myList;
	}

	public void setMyList(ArrayList<MyPageDTO> myList){
		this.myList=myList;
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message=message;
	}

	public String getDeleteFlg(){
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}
}
