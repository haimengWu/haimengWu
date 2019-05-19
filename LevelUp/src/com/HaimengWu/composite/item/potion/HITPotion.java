package com.HaimengWu.composite.item.potion;

import com.HaimengWu.composite.item.Potion;
import com.HaimengWu.beans.Player;

public class HITPotion extends Potion{

	private int level;
	private double HIT;
	
	public HITPotion(int level) {
		// TODO Auto-generated constructor stub
		super.setHIT(0.1 + level * 0.02);	
		super.setType("HITPotion");
		super.setLevel(level);
		this.HIT = super.getHIT();
		this.level = super.getLevel();
	}

	public void use(Player player){
		player.setHIT(player.getHIT() + this.getHIT());
		System.out.println(player.getName()+ " use "+getType()+", HIT increased by " + this.getHIT());
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getHIT() {
		return HIT;
	}

	public void setHIT(double hIT) {
		HIT = hIT;
	}

	public String toString() {
		return "HITPotion [level=" + level + ", HIT=" + HIT + "]";
	}
	
}
