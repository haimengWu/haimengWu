package com.HaimengWu.composite.item.potion;

import com.HaimengWu.composite.item.Potion;
import com.HaimengWu.beans.Player;

public class SPDPotion extends Potion{

	private int level;
	private int SPD;
	
	public SPDPotion(int level) {
		// TODO Auto-generated constructor stub
		super.setSPD(10 + level * 3);
		super.setType("SPDPotion");
		super.setLevel(level);
		SPD = super.getSPD();
		this.level = super.getLevel();
	}

	public void use(Player player){
		player.setSPD(player.getSPD() + this.getSPD());
		
		System.out.println(player.getName()+ " use "+getType()+", SPD increased by " + this.getSPD());
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSPD() {
		return SPD;
	}

	public void setSPD(int sPD) {
		SPD = sPD;
	}

	public String toString() {
		return "SPDPotion [level=" + level + ", SPD=" + SPD + "]";
	}
	
}
