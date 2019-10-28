package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware{

	private ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();
	private Map<String,Object> session;

//	private String itemName;
//	private String itemPrice;
//	private String itemStock;



	public String execute() throws Exception{
		ItemListDAO dao=new ItemListDAO();



//		itemName=session.get("itemName").toString();
//		itemPrice=session.get("itemPrice").toString();
//		itemStock=session.get("itemStock").toString();

//		itemList=dao.getItemInfo(itemName, itemPrice, itemStock);
		itemList = dao.getAllItems();

		String ret=SUCCESS;
		return ret;
	}

	public ArrayList<ItemInfoDTO> getItemList(){
		return itemList;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemList){
		this.itemList=itemList;
	}

//	public String getItemName(){
//		return itemName;
//	}
//
//	public void setItemName(String itemName){
//		this.itemName=itemName;
//	}
//
//	public String getItemPrice(){
//		return itemPrice;
//	}
//
//	public void setItemPrice(String itemPrice){
//		this.itemPrice=itemPrice;
//	}
//
//	public String getItemStock(){
//		return itemStock;
//	}
//
//	public void setItemStock(String itemStock){
//		this.itemStock=itemStock;
//	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
