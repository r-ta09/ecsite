package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

	DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	ArrayList<UserInfoDTO> userList=new ArrayList<UserInfoDTO>();

	public int userListDelete() throws SQLException{
	String sql="delete from login_user_transaction where admin_flg is NULL";

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
