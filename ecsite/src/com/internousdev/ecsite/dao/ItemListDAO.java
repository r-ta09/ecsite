package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	DBConnector db=new DBConnector();
	Connection con=db.getConnection();



//	public ArrayList<ItemInfoDTO> getItemInfo(String itemName,String itemPrice,String itemStock) throws Exception{
//		ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();
//
//
//		String sql="select * from item_info_transaction where item_name=? and item_price=? and item_stock=?";
//
//		try{
//			PreparedStatement ps=con.prepareStatement(sql);
//			ps.setString(1, itemName);
//			ps.setString(2, itemPrice);
//			ps.setString(3, itemStock);
//
//
//			ResultSet rs=ps.executeQuery();
//
//			while(rs.next()){
//				ItemInfoDTO dto=new ItemInfoDTO();
//
//				dto.setItemName(rs.getString("item_name"));
//				dto.setItemPrice(rs.getString("item_price"));
//				dto.setItemStock(rs.getString("item_stock"));
//				itemList.add(dto);
//			}
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//
//		return itemList;
//	}

	public ArrayList<ItemInfoDTO> getAllItems(){
		ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();

		String sql="select * from item_info_transaction";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				ItemInfoDTO dto=new ItemInfoDTO();

				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setId(rs.getString("id"));
				dto.setDate(rs.getString("insert_date"));
				itemList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return itemList;
	}

}
