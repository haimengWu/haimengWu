package com.HaimengWu.beans;

import java.util.ArrayList;
import java.util.List;

import com.HaimengWu.builder.Equipment;
import com.HaimengWu.builder.equipment.Accessories;
import com.HaimengWu.builder.equipment.Armor;
import com.HaimengWu.builder.equipment.Arms;
import com.HaimengWu.builder.equipment.Shoes;
import com.HaimengWu.composite.Item;
import com.HaimengWu.composite.item.Using;

//抽象玩家类
public abstract class Player {
	
	private int id;
	private int userId;
	private Equipment equipment;
	private List<Item> items = new ArrayList<Item>();
	
	public abstract String getName();
	public abstract void setName(String name);
	public abstract String getType();
	public abstract void setType(String type);
	public abstract boolean isVIP();
	public abstract void setVIP(boolean isVIP);
    public abstract int getLevel();
    public abstract void setLevel(int level);
    public abstract int getMaxHP();
    public abstract void setMaxHP(int maxHP);
    public abstract int getCurrentHP();
    public abstract void setCurrentHP(int currentHP);
    public abstract int getMaxEXP();
    public abstract void setMaxEXP(int maxEXP);
    public abstract int getCurrentEXP();
    public abstract void setCurrentEXP(int currentEXP);
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
    
    public Player(){
    	Armor armor = new Armor(1);
		Arms arms = new Arms(1);
		Shoes shoes = new Shoes(1);
		Accessories accessories = new Accessories(1);
		this.equipment = new Equipment.EquipmentBuilder().setArms(arms).
				setArmor(armor).setShoes(shoes).setAccessories(accessories).build();
    }
    //items
    public void addItem(Item item){
    	items.add(item);
    }
    public void removeItem(Item item){
    	items.remove(item);
    }
    public void clearItems(){
    	items.clear();
    }
    public void displayItems(){
    	System.out.println("Items:");
    	for(Item item : items){
    		System.out.println(item.toString());
    	}
    }
    public void useItem(Item item){
    	Using using = new Using();
    	using.use(this);
    	items.clear();
    }
    //equipment
    public void setEquipment(Equipment equipment){
    	this.equipment = equipment;
    }
    public Equipment getEquipment(){
    	return equipment;
    }
    public void wear(Armor armor){
    	this.equipment.setArmor(armor);
    }
    public void wear(Arms arms){
    	this.equipment.setArms(arms);
    }
    public void wear(Shoes shoes){
    	this.equipment.setShoes(shoes);
    }
    public void wear(Accessories accessories){
    	this.equipment.setAccessories(accessories);
    }
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void displayEquipments(){
    	System.out.println("Equipments:");
    	System.out.println(equipment.getArms().toString());
    	System.out.println(equipment.getArmor().toString());
    	System.out.println(equipment.getShoes().toString());
    	System.out.println(equipment.getAccessories().toString());
    }
        
    public abstract String levelUp();
    
    public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public void revive(){
		this.setCurrentHP(this.getMaxHP());
		this.setCurrentEXP(this.getCurrentEXP() / 2);
    }
    
    //state
    public abstract void normal();
    public abstract void vip();

   	
    public String toString() {
		return getClass().getSimpleName()+ "[Name=" + getName() + ", Level=" + getLevel()
				+ ", Type=" + getType() + ", isVIP=" + isVIP() + ", MaxHP=" + getMaxHP() + ", CurrentHP="
				+ getCurrentHP() + ", MaxEXP=" + getMaxEXP()
				+ ", CurrentEXP=" + getCurrentEXP() + ", ATK="
				+ getATK() + ", DEF=" + getDEF() + ", SPD="
				+ getSPD() + ", HIT=" + getHIT()*100 + "%, EVD="
				+ getEVD()*100 + "%, CRT=" + getCRT()*100 + "%]";
	}
}
