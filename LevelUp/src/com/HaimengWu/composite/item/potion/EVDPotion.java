package com.HaimengWu.composite.item.potion;

import com.HaimengWu.composite.item.Potion;
import com.HaimengWu.beans.Player;

public class EVDPotion extends Potion{

	private int level;
	private double EVD;
	
	public EVDPotion(int level) {
		// TODO Auto-generated constructor stub
		super.setEVD(0.1 + level * 0.02);	
		super.setType("EVDPotion");
		super.setLevel(level);
		this.EVD = super.getEVD();
		this.level = super.getLevel();
	}

	public void use(Player player){
		player.setEVD(player.getEVD() + this.getEVD());
		System.out.println(player.getName()+ " use "+getType()+", EVD increased by " + this.getEVD());
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getEVD() {
		return EVD;
	}

	public void setEVD(double eVD) {
		EVD = eVD;
	}

	public String toString() {
		return "EVDPotion [level=" + level + ", EVD=" + EVD + "]";
	}
	
}
