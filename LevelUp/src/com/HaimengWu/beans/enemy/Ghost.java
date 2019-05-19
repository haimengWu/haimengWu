package com.HaimengWu.beans.enemy;

import com.HaimengWu.beans.Enemy;
//”ƒ¡È¿‡
public class Ghost extends Enemy{
	
	private int level;
	private String name;
	private boolean isBoss;
	private int maxHP;
	private int currentHP;
	private int ATK;
	private int DEF;
	private int SPD;
	private double HIT;
	private double EVD;
	private double CRT;
	
	public Ghost(int level) {
		this.level = level;
		this.name = "Ghost";
		this.maxHP = 1;
		this.currentHP = 1;
		this.ATK = 30 + (level - 1) * 12;
		this.DEF = 0;
		this.SPD = 102 + (level - 1) * 4;
		this.HIT = 1;
		this.EVD = 0.75;
		this.CRT = 0.25;
	}
	
	public void normal(){
		if(isBoss){
			setATK(getATK() - getLevel() * 3);
			setEVD(getEVD() - 0.1);
			setCRT(getCRT() - 0.05);
			setBoss(false);
		}
	}
	
	public void boss(){
		if(!isBoss){
			setATK(getATK() + getLevel() * 3);
			setEVD(getEVD() + 0.1);
			setCRT(getCRT() + 0.05);
			setBoss(true);
		}
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getIsBoss() {
		return isBoss;
	}

	public void setBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}
	
	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public int getDEF() {
		return DEF;
	}

	public void setDEF(int dEF) {
		DEF = dEF;
	}

	public int getSPD() {
		return SPD;
	}

	public void setSPD(int sPD) {
		SPD = sPD;
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
	
}
