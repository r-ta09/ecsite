package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private int count;
	private String pay;
	private String message;


	public String execute(){

		String result=SUCCESS;

		int stock=Integer.parseInt(session.get("item_stock").toString());

		if(count>stock){
			setMessage("在庫が足りません");
			result=ERROR;
		}

		session.put("count", count);
		int count=Integer.parseInt(session.get("count").toString());
		int price=Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price", count*price);

		String payment;

		if(pay.equals("1")){
			payment="現金払い";
			session.put("pay", payment);
		}else{
			payment="クレジットカード";
			session.put("pay", payment);
		}



		return result;
	}

	public int getCount(){
		return count;
	}

	public void setCount(int count){
		this.count=count;
	}

	public String getPay(){
		return pay;
	}

	public void setPay(String pay){
		this.pay=pay;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message=message;
	}

}
