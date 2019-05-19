package com.HaimengWu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HaimengWu.controller.UserController;
import com.HaimengWu.beans.User;
import com.HaimengWu.util.DbUtil;


public class LoginServlet extends HttpServlet{

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
        try {
            User user=new User(username,password);
            User currentUser=uc.login(user);
            if(currentUser==null){
                System.out.println("Login failed");
                request.setAttribute("error", "Login failed");
                request.setAttribute("username", username);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else{
                System.out.println("Login successful");
                HttpSession session=request.getSession();
                session.setAttribute("currentUser",currentUser);
                session.setAttribute("userId",currentUser.getId());
                response.sendRedirect("main.jsp");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
}