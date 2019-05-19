package com.HaimengWu.beans.player;

import com.HaimengWu.beans.Player;
//∑® ¶¿‡
public class Mage extends Player {
	
	private String name;
	private String type;
	private int level;
	private int maxHP;
	private int currentHP;
	private int maxEXP;
	private int currentEXP;
	private int ATK;
	private int DEF;
	private int SPD;
	private double HIT;
	private double EVD;
	private double CRT;
	//state
	private boolean isVIP;
	
	public Mage(String name) {
		super();
		this.name = name;
		this.type = "Mage";
		this.level = 1;
		this.maxHP = 275;
		this.currentHP = 275;
		this.maxEXP = 40;
		this.currentEXP = 0;
		this.ATK = 32;
		this.DEF = 6;
		this.SPD = 105;
		this.HIT = 1;
		this.EVD = 0;
		this.CRT = 0.15;
		this.isVIP = false;
	}

	public String levelUp(){
		this.setCurrentEXP(getCurrentEXP() - getMaxEXP());
		this.setLevel(getLevel() + 1);
		this.setMaxEXP(25 + getLevel() * getLevel() * 15);
		this.setMaxHP(this.getMaxHP() + 50);
		this.setCurrentHP(this.getMaxHP());
		this.setATK(this.getATK() + 8);
		this.setDEF(this.getDEF() + 2);
		this.setSPD(this.getSPD() + 5);
		System.out.println(this.getName() + " levels up to LV" + this.getLevel());
		return this.getName() + " levels up to LV" + this.getLevel();
	}

	public void normal(){
		if(!isVIP){
	    	this.ATK /= 1.5;
	    	this.DEF /= 1.5;
	    	this.SPD /= 1.25;
	    	this.EVD /= 2;
	    	this.CRT /= 2;
    	}
	}
	
    public void vip(){
    	if(isVIP){
	    	this.ATK *= 1.5;
	    	this.DEF *= 1.5;
	    	this.SPD *= 1.25;
	    	this.EVD *= 2;
	    	this.CRT *= 2;
    	}
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getMaxEXP() {
		return maxEXP;
	}

	public void setMaxEXP(int maxEXP) {
		this.maxEXP = maxEXP;
	}

	public int getCurrentEXP() {
		return currentEXP;
	}

	public void setCurrentEXP(int currentEXP) {
		this.currentEXP = currentEXP;
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

	public boolean isVIP() {
		return isVIP;
	}

	public void setVIP(boolean isVIP) {
		this.isVIP = isVIP;
	}
	
}
