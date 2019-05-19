package com.HaimengWu.composite.item.potion;

import com.HaimengWu.composite.item.Potion;
import com.HaimengWu.beans.Player;

public class HPPotion extends Potion{

	private int level;
	private int HP;
	
	public HPPotion(int level) {
		// TODO Auto-generated constructor stub
		super.setHP(120 + level * 30);	
		super.setType("HPPotion");
		super.setLevel(level);
		this.HP = super.getHP();
		this.level = super.getLevel();
	}

	public void use(Player player){
		if(player.getCurrentHP() + this.getHP() >= player.getMaxHP()){
			player.setCurrentHP(player.getMaxHP());
		}else{
			player.setCurrentHP(player.getCurrentHP() + this.getHP());
		}
		
		System.out.println(player.getName()+ " use "+getType()+", HP increased by " + this.getHP());
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public String toString() {
		return "HPPotion [level=" + level + ", HP=" + HP + "]";
	}
	
}
