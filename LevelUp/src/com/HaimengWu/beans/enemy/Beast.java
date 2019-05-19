package com.HaimengWu.beans.enemy;

import com.HaimengWu.beans.Enemy;
//“∞ ﬁ¿‡
public class Beast extends Enemy{

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
	
	public Beast(int level) {
		this.level = level;
		this.name = "Beast";
		this.isBoss = false;
		this.maxHP = 225 + (level - 1) * 95;
		this.currentHP = 225 + (level - 1) * 95;
		this.ATK = 22 + (level - 1) * 8;
		this.DEF = 12 + (level - 1) * 4;
		this.SPD = 95 + (level - 1) * 3;
		this.HIT = 1;
		this.EVD = 0;
		this.CRT = 0.05;
	}

	public void normal(){
		if(isBoss){
			setMaxHP(getMaxHP() / 2);
			setCurrentHP(getCurrentHP() / 2);
			setATK(getATK() - getLevel() * 4);
			setDEF(getDEF() - getLevel() * 2);
			setEVD(getEVD() - 0.1);
			setCRT(getCRT() - 0.05);
			setBoss(false);
		}
	}
	
	public void boss(){
		if(!isBoss){
			setMaxHP(getMaxHP() * 2);
			setCurrentHP(getCurrentHP() * 2);
			setATK(getATK() + getLevel() * 4);
			setDEF(getDEF() + getLevel() * 2);
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
