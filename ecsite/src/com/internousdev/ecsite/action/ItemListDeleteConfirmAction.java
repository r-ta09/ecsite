package com.internousdev.ecsite.action;

import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemListDeleteConfirmAction extends ActionSupport{

	private ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();

	public String execute() throws Exception{
		return SUCCESS;
	}

	public ArrayList<ItemInfoDTO> getItemList(){
		return itemList;
	}

	public void setItemList(ArrayList<ItemInfoDTO> itemList){
		this.itemList=itemList;
	}
}
