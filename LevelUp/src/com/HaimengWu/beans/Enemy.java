package com.HaimengWu.beans;
//抽象敌人类
public abstract class Enemy {
	
	public abstract int getLevel();
	public abstract void setLevel(int level);
	public abstract String getName();
	public abstract void setName(String name);
	public abstract boolean getIsBoss();
	public abstract void setBoss(boolean isBoss);
    public abstract int getMaxHP();
    public abstract void setMaxHP(int maxHP);
    public abstract int getCurrentHP();
    public abstract void setCurrentHP(int currentHP);
    public abstract int getATK();//攻击力
    public abstract void setATK(int ATK);
    public abstract int getDEF();//防御力
    public abstract void setDEF(int DEF);
    public abstract int getSPD();//速度
    public abstract void setSPD(int SPD);
    public abstract double getHIT();//命中率
    public abstract void setHIT(double HIT);
    public abstract double getEVD();//闪避率
    public abstract void setEVD(double EVD);
    public abstract double getCRT();//暴击率
    public abstract void setCRT(double CRT);  
    public abstract void normal();
    public abstract void boss();
    
	@Override
	public String toString() {
		return getClass().getSimpleName()+ ", Level=" + getLevel()
				+ ", isBoss=" + getIsBoss() + ", MaxHP=" + getMaxHP() + ", CurrentHP="
				+ getCurrentHP() + ", ATK="
				+ getATK() + ", DEF=" + getDEF() + ", SPD="
				+ getSPD() + ", HIT=" + getHIT()*100 + "%, EVD="
				+ getEVD()*100 + "%, CRT=" + getCRT()*100 + "%]";
	}
}
