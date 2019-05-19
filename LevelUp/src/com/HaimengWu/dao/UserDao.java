package com.HaimengWu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.HaimengWu.beans.User;
import com.HaimengWu.util.DbUtil;

public class UserDao {

	private DbUtil db = new DbUtil();
	private Connection con = null;
	
    public User login(User user) throws SQLException{
        User resultUser=null;
        try {
			con = db.getCon();
			String sql="select * from user where username=? and password=?";
	        PreparedStatement ps=con.prepareStatement(sql);//
	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getPassword());
	        ResultSet rs=ps.executeQuery();
	        if(rs.next()){
	            resultUser=new User();
	        	resultUser.setId(rs.getInt("id"));
	            resultUser.setUsername(rs.getString("username"));
	            resultUser.setPassword(rs.getString("password"));
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
        return resultUser;
    }
    
    public User findByUsername(String username) throws SQLException{
    	User resultUser=null;
		try {
			con = db.getCon();
			String sql = "select * from user where username=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
	        ResultSet rs=ps.executeQuery();
	        if(rs.next()){
	        	resultUser=new User();
	        	resultUser.setId(rs.getInt("id"));
	            resultUser.setUsername(rs.getString("username"));
	            resultUser.setPassword(rs.getString("password"));
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultUser;  
    }
    
    public void addUser(User user) throws SQLException{
    	try {
			con = db.getCon();
			String sql= "insert into user(username,password) values(?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
	        ps.setString(1, user.getUsername());
	        ps.setString(2, user.getPassword());
	        ps.execute();
	        }
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
    }
    
    public void updateUser(User user) throws SQLException{
    	try {
			con = db.getCon();
			String sql= "update user set username=? ,password=? where id = ?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getId());
	        ps.execute();
	        }
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
    }
    
    public void deleteUser(User user) throws SQLException{
    	try {
			con = db.getCon();
			String sql= "delete from user where id = ?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, user.getId());
	        ps.execute();
	        }
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
    }
}
