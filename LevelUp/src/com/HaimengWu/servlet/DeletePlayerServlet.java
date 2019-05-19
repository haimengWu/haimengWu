package com.HaimengWu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HaimengWu.controller.PlayerController;
import com.HaimengWu.beans.Player;
import com.HaimengWu.util.DbUtil;


public class DeletePlayerServlet extends HttpServlet{

    DbUtil db=new DbUtil();
    PlayerController pc=new PlayerController();

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playername = request.getParameter("playername");
        Player player = null;    
        try {
        	player = pc.findByName(playername);
        	pc.deletePlayer(player);
            //request.setAttribute("player",player); 
            //request.getRequestDispatcher( "game.jsp").forward(request,response);
        	request.getRequestDispatcher("playerList.jsp").forward(request,response);         
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
}