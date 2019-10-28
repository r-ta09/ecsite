package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String adminFlg;
	private Map<String,Object> session;
	private LoginDAO LDAO=new LoginDAO();
	private LoginDTO LDTO=new LoginDTO();
	private BuyItemDAO BDAO=new BuyItemDAO();

	public String execute(){
		String result=ERROR;
		LDTO=LDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser",LDTO);


		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result=SUCCESS;
			BuyItemDTO BDTO=BDAO.getBuyItemInfo();

			session.put("login_user_id", LDTO.getLoginId());
			session.put("id", BDTO.getId());
			session.put("buyItem_name", BDTO.getItemName());
			session.put("buyItem_price", BDTO.getItemPrice());
			session.put("item_stock", BDTO.getItemStock());
			session.put("admin_flg", LDTO.getAdminFlg());

			if(session.containsKey("admin_flg")){
				result="admin";
			}

			return result;
		}


		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	public String getAdminFlg(){
		return adminFlg;
	}

	public void setAdminFlg(String adminFlg){
		this.adminFlg=adminFlg;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}
}
