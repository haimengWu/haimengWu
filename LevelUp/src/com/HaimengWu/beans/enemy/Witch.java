package com.HaimengWu.beans.enemy;

import com.HaimengWu.beans.Enemy;
//Å®Î×Àà
public class Witch extends Enemy{

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
	
	public Witch(int level) {
		this.level = level;
		this.name = "Witch";
		this.maxHP = 280 + (level - 1) * 85;
		this.currentHP = 280 + (level - 1) * 85;
		this.ATK = 35 + (level - 1) * 20;
		this.DEF = 10 + (level - 1) * 4;
		this.SPD = 99 + (level - 1) * 1;
		this.HIT = 0.5;
		this.EVD = 0;
		this.CRT = 0.1;
	}
	
	public void normal(){
		if(isBoss){
			setMaxHP(getMaxHP() - getLevel() / 2);
			setCurrentHP(getCurrentHP() - getLevel() / 2);
			setATK(getATK() - getLevel() * 6);
			setDEF(getDEF() - getLevel() * 2);
			setHIT(getHIT() - 0.15);
			setCRT(getCRT() - 0.1);
			setBoss(false);
		}
	}
	
	public void boss(){
		if(!isBoss){
			setMaxHP(getMaxHP() * 2);
			setCurrentHP(getCurrentHP() * 2);
			setATK(getATK() + getLevel() * 6);
			setDEF(getDEF() + getLevel() * 2);
			setHIT(getHIT() + 0.15);
			setCRT(getCRT() + 0.1);
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

