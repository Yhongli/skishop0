package com.skishop.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.skishop.dao.BaseDao;
import com.skishop.entity.User;

public class UserDao {
	
	//连接数据库
	Connection con=BaseDao.getCon();
	public void register(User us){
		String orl="insert into user value(?,?,?,?)";
		try{
			PreparedStatement  pst=con.prepareStatement(orl);
			pst.setInt(0, us.getUserid());
			pst.setString(1, us.getName());
			pst.setString(2, us.getPassword());
			pst.setString(3, us.getEmail());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User findAll(String email){
		try{
			User p=new User();
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from user where email=?");
			pstm.setString(1, email);
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				p.setUserid(rs.getInt(0));
				p.setName(rs.getString(1));
				p.setEmail(rs.getString(2));
				p.setPassword(rs.getString(3));
			}
			return p;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
}
