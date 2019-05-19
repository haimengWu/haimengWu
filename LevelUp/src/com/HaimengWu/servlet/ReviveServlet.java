package com.HaimengWu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HaimengWu.beans.Player;
import com.HaimengWu.controller.PlayerController;
import com.HaimengWu.util.DbUtil;


public class ReviveServlet extends HttpServlet{

    DbUtil db=new DbUtil();
    PlayerController pc=new PlayerController();
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
    	Player player = (Player)request.getSession().getAttribute("player");
    	player.revive();
    	HttpSession session=request.getSession();
        session.setAttribute("player",player);
        response.sendRedirect("fighting.jsp");    
    }
    
    
}