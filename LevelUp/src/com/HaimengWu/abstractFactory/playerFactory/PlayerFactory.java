package com.HaimengWu.abstractFactory.playerFactory;

import com.HaimengWu.abstractFactory.PlayerAbstarctFactory;
import com.HaimengWu.beans.Player;
//玩家工厂类，实现单例
public class PlayerFactory {
	
	private static PlayerFactory instance;
	//Lazy Instantiation for Creating Players
	private PlayerFactory(){}
	
	public static synchronized PlayerFactory getInstance(){
		if(instance == null){
			instance = new PlayerFactory();
		}
		return instance;
	}
	
	public static Player getPlayer(PlayerAbstarctFactory player){
		return player.createPlayer();
	}
}
