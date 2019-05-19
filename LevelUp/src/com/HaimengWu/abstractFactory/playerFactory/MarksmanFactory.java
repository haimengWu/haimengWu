package com.HaimengWu.abstractFactory.playerFactory;

import com.HaimengWu.beans.player.Marksman;

import com.HaimengWu.abstractFactory.PlayerAbstarctFactory;
import com.HaimengWu.beans.Player;
//���ֹ�����
public class MarksmanFactory implements PlayerAbstarctFactory {
	
	private String name;
	
	public MarksmanFactory(String name) {
		this.name = name;
	}
	
	public Player createPlayer(){
		return new Marksman(name);
	}
}