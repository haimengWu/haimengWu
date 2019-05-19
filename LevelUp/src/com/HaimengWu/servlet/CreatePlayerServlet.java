package com.HaimengWu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HaimengWu.controller.PlayerController;
import com.HaimengWu.abstractFactory.playerFactory.*;
import com.HaimengWu.beans.Player;
import com.HaimengWu.util.DbUtil;


public class CreatePlayerServlet extends HttpServlet{

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
        String playername=request.getParameter("playername");
        String type=request.getParameter("type");
        String userId = request.getParameter("userId");
        int userid = Integer.parseInt(request.getParameter("userId"));
        Player player = null;       
        try {
        	if(type.equals("Fighter")){
        		player = PlayerFactory.getPlayer(new FighterFactory(playername));        		      			
        	}else if(type.equals("Mage")){
        		player = PlayerFactory.getPlayer(new MageFactory(playername));
        	}else if(type.equals("Marksman")){
        		player = PlayerFactory.getPlayer(new MarksmanFactory(playername));
        	}else if(type.equals("Assassin")){
        		player = PlayerFactory.getPlayer(new AssassinFactory(playername));
        	}
        	player.setUserId(userid);
            pc.createPlayer(player);
            
            System.out.println("create successful");
            request.setAttribute("player",player); 
            request.setAttribute("userId",userId);
            request.getRequestDispatcher("playerList.jsp").forward(request,response); 
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
}