package com.HaimengWu.builder.equipment;

import com.HaimengWu.beans.Player;
import com.HaimengWu.composite.Item;
import com.HaimengWu.util.myRandom;

public class Shoes extends Item{
	
	private int id;
	private String type;
	private int level;
	private int SPD;
	
	public Shoes(int level){
		this.type = "Shoes";
		this.level = level;
		this.SPD = 10 + (level - 1) * 5 * myRandom.randomInt(80,120)/100;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	public void setSPD(int SPD) {
		this.SPD = SPD;
	}

	public String toString() {
		return "Shoes [level=" + level + ", SPD=" + SPD + "]";
	}

	public void use(Player player) {
		player.wear(this);
	}
	
}
