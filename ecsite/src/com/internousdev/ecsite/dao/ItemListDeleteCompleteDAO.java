package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {

	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();

	public int itemListDelete() throws SQLException{

		String sql="delete from item_info_transaction";

		int ret=0;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ret=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return ret;
	}
}
