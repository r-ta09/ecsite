package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	DBConnector db=new DBConnector();
	Connection con=db.getConnection();


	String sql="select * from login_user_transaction";

	public ArrayList<UserInfoDTO> getAllUsers(){
		ArrayList<UserInfoDTO> userList=new ArrayList<UserInfoDTO>();

	try{
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();

		while(rs.next()){
			UserInfoDTO dto=new UserInfoDTO();
			dto.setUserName(rs.getString("user_name"));
			dto.setPassword(rs.getString("login_pass"));
			dto.setUserId(rs.getString("login_id"));
			dto.setId(rs.getString("id"));
			dto.setDate(rs.getString("insert_date"));
			userList.add(dto);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return userList;
	}
}
