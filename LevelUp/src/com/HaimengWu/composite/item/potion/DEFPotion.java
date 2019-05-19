package com.HaimengWu.composite.item.potion;

import com.HaimengWu.composite.item.Potion;
import com.HaimengWu.beans.Player;

public class DEFPotion extends Potion{

	private int level;
	private int DEF;
	
	public DEFPotion(int level) {
		// TODO Auto-generated constructor stub
		super.setDEF(5 + level * 2);	
		super.setType("DEFPotion");
		super.setLevel(level);
		this.DEF = super.getDEF();
		this.level = super.getLevel();
	}

	public void use(Player player){
		player.setDEF(player.getDEF() + this.getDEF());
		System.out.println(player.getName()+ " use "+getType()+", DEF increased by " + this.getDEF());
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getDEF() {
		return DEF;
	}

	public void setDEF(int dEF) {
		DEF = dEF;
	}

	public String toString() {
		return "DEFPotion [level=" + level + ", DEF=" + DEF + "]";
	}
	
}
