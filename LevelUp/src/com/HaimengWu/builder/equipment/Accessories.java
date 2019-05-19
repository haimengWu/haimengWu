package com.HaimengWu.builder.equipment;

import com.HaimengWu.beans.Player;
import com.HaimengWu.composite.Item;
import com.HaimengWu.util.myRandom;

public class Accessories extends Item{
	
	private int id;
	private String type;
	private int level;
	private double HIT;
	private double EVD;
	private double CRT;

	
	public Accessories(int level){
		this.type = "Accessories";
		this.level = level;
		this.CRT = (level - 1) * 0.01 +  0.01 * myRandom.randomInt(0,2);
		this.HIT = (level - 1) * 0.01 +  0.01 * myRandom.randomInt(0,2);
		this.EVD = (level - 1) * 0.01 +  0.01 * myRandom.randomInt(0,2);
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
	public double getHIT() {
		return HIT;
	}
	public void setHIT(double HIT) {
		this.HIT = HIT;
	}
	public double getEVD() {
		return EVD;
	}
	public void setEVD(double EVD) {
		this.EVD = EVD;
	}
	public double getCRT() {
		return CRT;
	}
	public void setCRT(double CRT) {
		this.CRT = CRT;
	}

	public String toString() {
		return "Accessories [level=" + level + ", HIT=" + HIT + ", EVD=" + EVD
				+ ", CRT=" + CRT + "]";
	}

	public void use(Player player) {
		player.wear(this);
	}
	
}
