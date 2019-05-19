package com.HaimengWu.controller;

import java.sql.SQLException;
import java.util.List;

import com.HaimengWu.beans.Player;
import com.HaimengWu.dao.PlayerDao;

public class PlayerController {
    
	private PlayerDao pd = new PlayerDao();
	
    public void createPlayer(Player player) throws SQLException{
    	pd.createPlayer(player);
        return;
    }
    
    public Player findByName(String name) throws SQLException{
    	return pd.findByName(name);
    }
    
    public Player findById(int id) throws SQLException{
    	return pd.findById(id);
    }

    public List<Player> findAll() throws SQLException{
    	return pd.findAll();
    }
    
    public List<Player> findAllByUserId(int userId) throws SQLException{
    	return pd.findAllByUserId(userId);
    }
    
    public void updatePlayer(Player player) throws SQLException{
    	pd.updatePlayer(player);
    }
    
    public void deletePlayer(Player player) throws SQLException{
    	pd.deletePlayer(player);
    }
}
