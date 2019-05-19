package com.HaimengWu.abstractFactory.playerFactory;

import com.HaimengWu.beans.player.Marksman;

import com.HaimengWu.abstractFactory.PlayerAbstarctFactory;
import com.HaimengWu.beans.Player;
//射手工厂类
public class MarksmanFactory implements PlayerAbstarctFactory {
	
	private String name;
	
	public MarksmanFactory(String name) {
		this.name = name;
	}
	
	public Player createPlayer(){
		return new Marksman(name);
	}
}