package com.HaimengWu.controller;

import java.sql.SQLException;

import com.HaimengWu.beans.User;
import com.HaimengWu.dao.UserDao;

public class UserController {
	
	private UserDao ud = new UserDao();
    
    public User login(User user) throws SQLException{
        return ud.login(user);
    }
    
    public boolean register(User user) throws SQLException{

        if(ud.findByUsername(user.getUsername())!=null){
        	return false;
        }
        else{
	    	ud.addUser(user);
	    	return true;
        }
    }
    
    public User findByUsername(String username) throws SQLException{
    	return ud.findByUsername(username);
    }
}
