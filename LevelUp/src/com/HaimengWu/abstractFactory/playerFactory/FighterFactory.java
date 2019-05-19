package com.HaimengWu.abstractFactory.playerFactory;

import com.HaimengWu.beans.player.Fighter;

import com.HaimengWu.abstractFactory.PlayerAbstarctFactory;
import com.HaimengWu.beans.Player;
//战士工厂类
public class FighterFactory implements PlayerAbstarctFactory {
	
	private String name;
	
	public FighterFactory(String name) {
		this.name = name;
	}
	
	public Player createPlayer(){
		return new Fighter(name);
	}
}
