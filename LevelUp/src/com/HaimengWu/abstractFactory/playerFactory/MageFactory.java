package com.HaimengWu.abstractFactory.playerFactory;

import com.HaimengWu.beans.player.Mage;

import com.HaimengWu.abstractFactory.PlayerAbstarctFactory;
import com.HaimengWu.beans.Player;
//法师工厂类
public class MageFactory implements PlayerAbstarctFactory {
	
	private String name;
	
	public MageFactory(String name) {
		this.name = name;
	}
	
	public Player createPlayer(){
		return new Mage(name);
	}
}