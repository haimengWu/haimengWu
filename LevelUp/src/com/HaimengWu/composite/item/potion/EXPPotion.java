package com.HaimengWu.composite.item.potion;

import com.HaimengWu.composite.item.Potion;
import com.HaimengWu.beans.Player;

public class EXPPotion extends Potion{

	private int level;
	private int EXP;
	
	public EXPPotion(int level) {
		// TODO Auto-generated constructor stub
		super.setEXP(15 + level * level * 5);	
		super.setType("EXPPotion");
		super.setLevel(level);
		this.EXP = super.getEXP();
		this.level = super.getLevel();
	}

	public void use(Player player){
		player.setCurrentEXP(player.getCurrentEXP() + this.getEXP());
		System.out.println(player.getName()+ " use "+getType()+", EXP increased by " + this.getEXP());
		while(player.getCurrentEXP() > player.getMaxEXP()){
			player.levelUp();
		}
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getEXP() {
		return EXP;
	}

	public void setEXP(int eXP) {
		EXP = eXP;
	}

	public String toString() {
		return "EXPPotion [level=" + level + ", EXP=" + EXP + "]";
	}
	
}
