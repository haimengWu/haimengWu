package com.HaimengWu.composite.item.potion;

import com.HaimengWu.composite.item.Potion;
import com.HaimengWu.beans.Player;

public class ATKPotion extends Potion{

	private int level;
	private int ATK;
	
	public ATKPotion(int level) {
		// TODO Auto-generated constructor stub
		super.setLevel(level);
		super.setATK(10 + level * 4);	
		super.setType("ATKPotion");
		ATK = super.getATK();
		this.level = super.getLevel();
	}

	public void use(Player player){
		player.setATK(player.getATK() + this.getATK());
		System.out.println(player.getName()+ " use "+getType()+", ATK increased by " + this.getATK());
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public String toString() {
		return "ATKPotion [level=" + level + ", ATK=" + ATK + "]";
	}
	
}
