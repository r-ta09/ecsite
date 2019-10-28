package com.internousdev.ecsite.action;

import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{

	private String message;
	private ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();

	ItemListDeleteCompleteDAO dao=new ItemListDeleteCompleteDAO();

	public String execute() throws Exception{
		int res=dao.itemListDelete();
		String ret=SUCCESS;

		if(res>0){
			itemList=null;
			setMessage("商品情報が正しく削除されました。");
		}else if(res==0){
			setMessage("商品情報が正しく削除されませんでした。");
		}
		return ret;

	}

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message=message;
	}

	public ArrayList<ItemInfoDTO> getItemList(){
		return itemList;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemList){
		this.itemList=itemList;
	}
}
