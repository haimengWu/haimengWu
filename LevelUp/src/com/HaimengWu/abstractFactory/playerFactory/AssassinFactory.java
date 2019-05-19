package com.HaimengWu.abstractFactory.playerFactory;

import com.HaimengWu.beans.player.Assassin;

import com.HaimengWu.abstractFactory.PlayerAbstarctFactory;
import com.HaimengWu.beans.Player;
//刺客工厂类
public class AssassinFactory implements PlayerAbstarctFactory {
	
	private String name;
	
	public AssassinFactory(String name) {
		this.name = name;
	}
	
	public Player createPlayer(){
		return new Assassin(name);
	}
}
