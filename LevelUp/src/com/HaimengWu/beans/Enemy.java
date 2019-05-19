package com.HaimengWu.beans;
//���������
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
    public abstract int getATK();//������
    public abstract void setATK(int ATK);
    public abstract int getDEF();//������
    public abstract void setDEF(int DEF);
    public abstract int getSPD();//�ٶ�
    public abstract void setSPD(int SPD);
    public abstract double getHIT();//������
    public abstract void setHIT(double HIT);
    public abstract double getEVD();//������
    public abstract void setEVD(double EVD);
    public abstract double getCRT();//������
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
