package com.HaimengWu.builder.equipment;

import com.HaimengWu.beans.Player;
import com.HaimengWu.composite.Item;
import com.HaimengWu.util.myRandom;

public class Armor extends Item{
	
	private int id;
	private String type;
	private int level;
	private int DEF;
	
	public Armor(int level){
		this.type = "Armor";
		this.level = level;
		this.DEF = 5 + (level - 1) * 3 * myRandom.randomInt(80,120)/100;
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
	public int getDEF() {
		return DEF;
	}
	public void setDEF(int DEF) {
		this.DEF = DEF;
	}
	
	public String toString() {
		return "Armor [level=" + level + ", DEF=" + DEF + "]";
	}

	public void use(Player player) {
		player.wear(this);
	}
	
}
