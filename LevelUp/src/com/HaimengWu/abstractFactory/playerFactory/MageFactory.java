package com.HaimengWu.abstractFactory.playerFactory;

import com.HaimengWu.beans.player.Mage;

import com.HaimengWu.abstractFactory.PlayerAbstarctFactory;
import com.HaimengWu.beans.Player;
//��ʦ������
public class MageFactory implements PlayerAbstarctFactory {
	
	private String name;
	
	public MageFactory(String name) {
		this.name = name;
	}
	
	public Player createPlayer(){
		return new Mage(name);
	}
}