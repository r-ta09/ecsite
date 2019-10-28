package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {


	public int buyItemInfo(String item_transaction_id,String total_price,String total_count,String user_master_id,String pay) throws SQLException{


		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil du=new DateUtil();

		String sql="insert into user_buy_item_transaction"
				+ "(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date)"
				+ "values(?,?,?,?,?,?)";

		int result=0;
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, du.getDate());

		result=ps.executeUpdate();


		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return result;
	}

	public void updateItemInfo(int count,String stock) throws SQLException{
//		String sql="UPDATE item_info_transaction,user_buy_item_transaction "
//				+ "SET item_info_transaction.item_stock=item_info_transaction.item_stock - user_buy_item_transaction.total_count FROM item_info_transaction as item "
//				+ "INNER JOIN user_buy_item_transaction as user ON item_info_transaction.id=user_buy_item_transaction.item_transaction_id"
//				+ "WHERE item.item_stock=? AND user.total_count=?";



		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="UPDATE item_info_transaction SET item_stock=item_stock - ? WHERE id=?";

		PreparedStatement ps;

		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1, count);
			ps.setString(2, stock);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

	}


}
