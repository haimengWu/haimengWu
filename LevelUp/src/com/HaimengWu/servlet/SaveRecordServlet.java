package com.HaimengWu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HaimengWu.beans.Player;
import com.HaimengWu.controller.PlayerController;
import com.HaimengWu.util.DbUtil;


public class SaveRecordServlet extends HttpServlet{

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
    	System.out.println(player);
    	try {
			pc.updatePlayer(player);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	request.getRequestDispatcher("game.jsp").forward(request, response);  
    }
    
    
}