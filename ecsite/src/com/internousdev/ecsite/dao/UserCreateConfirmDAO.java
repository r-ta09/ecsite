package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {

	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	public boolean loginUser(String loginUserId){
		String sql="select count(*) as count from login_user_transaction where login_id=?";

		boolean ret=false;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				if(rs.getInt("count")>0){
					ret=true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}
}
