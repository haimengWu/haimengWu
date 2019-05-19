package com.HaimengWu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HaimengWu.controller.UserController;
import com.HaimengWu.beans.User;
import com.HaimengWu.util.DbUtil;


public class RegisterServlet extends HttpServlet{

    DbUtil db=new DbUtil();
    UserController uc = new UserController();
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String comfirmPassword=request.getParameter("comfirmPassword");
        if(!password.equals(comfirmPassword)){
        	System.out.println("Inconsistent password and confirmation password");
        	request.setAttribute("username", username);
            request.setAttribute("error", "Inconsistent password and confirmation password");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        else{
	        try {
	            User user=new User(username,password);
	            boolean isRgegister = uc.register(user);
	            if(!isRgegister){
	                System.out.println("Username already exists");
	                request.setAttribute("error", "Username already exists");
	                request.getRequestDispatcher("register.jsp").forward(request, response);
	            }else{
	                System.out.println("registration success");
	                response.sendRedirect("login.jsp");
	            }
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
        }
        
    }
    
    
}