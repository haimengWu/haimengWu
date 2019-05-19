package com.HaimengWu.composite.item.potion;

import com.HaimengWu.composite.item.Potion;
import com.HaimengWu.beans.Player;

public class CRTPotion extends Potion{

	private int level;
	private double CRT;
	
	public CRTPotion(int level) {
		// TODO Auto-generated constructor stub
		super.setCRT(0.1 + level * 0.02);	
		super.setType("CRTPotion");
		super.setLevel(level);
		this.CRT = super.getCRT();
		this.level = super.getLevel();
	}

	public void use(Player player){
		player.setCRT(player.getCRT() + this.getCRT());
		System.out.println(player.getName()+ " use "+getType()+", CRT increased by " + this.getCRT());
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getCRT() {
		return CRT;
	}

	public void setCRT(double cRT) {
		CRT = cRT;
	}

	public String toString() {
		return "CRTPotion [level=" + level + ", CRT=" + CRT + "]";
	}
	
}
