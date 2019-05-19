package com.HaimengWu.composite.item;

import com.HaimengWu.beans.Player;
import com.HaimengWu.composite.Item;
//“©∆∑¿‡
public abstract class Potion extends Item{
	
	private int id;
	private int level;
	private int HP;
	private int EXP;
	private int ATK;
	private int DEF;
	private int SPD;
	private double HIT;
	private double EVD;
	private double CRT;


	
	public Potion() {
		level = 0;
		ATK = 0;
		DEF = 0;
		SPD = 0;
		HIT = 0;
		EVD = 0;
		CRT = 0;
		HP = 0;
		EXP = 0;
	}

	public abstract void use(Player player); 

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDEF() {
		return DEF;
	}

	public void setDEF(int DEF) {
		this.DEF = DEF;
	}

	public int getATK() {
		return ATK;
	}

	public void setATK(int ATK) {
		this.ATK = ATK;
	}

	public int getSPD() {
		return SPD;
	}

	public void setSPD(int SPD) {
		this.SPD = SPD;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int HP) {
		this.HP = HP;
	}

	public int getEXP() {
		return EXP;
	}

	public void setEXP(int EXP) {
		this.EXP = EXP;
	}

	public double getHIT() {
		return HIT;
	}

	public void setHIT(double hIT) {
		HIT = hIT;
	}

	public double getEVD() {
		return EVD;
	}

	public void setEVD(double eVD) {
		EVD = eVD;
	}

	public double getCRT() {
		return CRT;
	}

	public void setCRT(double cRT) {
		CRT = cRT;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String toString() {
		return "Potion [level=" + level + ", type=" + this.getType() + ", HP=" + HP
				+ ", EXP=" + EXP + ", ATK=" + ATK + ", DEF=" + DEF + ", SPD="
				+ SPD + ", HIT=" + HIT + ", EVD=" + EVD + ", CRT=" + CRT + "]";
	}
	
}
