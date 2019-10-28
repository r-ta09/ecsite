package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(String item_transaction_id,String user_master_id) throws Exception{
		ArrayList<MyPageDTO> mdto=new ArrayList<MyPageDTO>();

		String sql="SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date"
				+ " FROM user_buy_item_transaction ubit"
				+ " LEFT JOIN item_info_transaction iit"
				+ " ON ubit.item_transaction_id=iit.id"
				+ " WHERE ubit.item_transaction_id=? AND ubit.user_master_id=?"
				+ " ORDER BY ubit.insert_date DESC";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);

			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				MyPageDTO dto=new MyPageDTO();

				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setTotalPrice(rs.getString("total_price"));
				dto.setTotalCount(rs.getString("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsert_date(rs.getString("insert_date"));
				mdto.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return mdto;
	}

	public int buyItemHistoryDelete(String item_transaction_id,String user_master_id) throws SQLException{
		String sql="delete from user_buy_item_transaction where item_transaction_id=? and user_master_id=?";

		PreparedStatement ps;


		int result=0;

		try{
			ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, user_master_id);
			result=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
}
