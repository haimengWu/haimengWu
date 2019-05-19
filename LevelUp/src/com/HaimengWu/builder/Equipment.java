package com.HaimengWu.builder;

import com.HaimengWu.builder.equipment.*;

public class Equipment {
	
	private Arms arms;
	private Armor armor;
	private Shoes shoes;
	private Accessories accessories;
	
	private Equipment(EquipmentBuilder builder){
		this.arms = builder.arms;
		this.armor = builder.armor;
		this.shoes = builder.shoes;
		this.accessories = builder.accessories;
	}
	
	public Arms getArms() {
		return arms;
	}
	
	public Armor getArmor() {
		return armor;
	}
	
	public Shoes getShoes() {
		return shoes;
	}
	
	public Accessories getAccessories() {
		return accessories;
	}
	
	public void setArms(Arms arms) {
		this.arms = arms;
	}
	
	public void setArmor(Armor armor) {
		this.armor = armor;
	}
	
	public void setShoes(Shoes shoes) {
		this.shoes = shoes;
	}
	
	public void setAccessories(Accessories accessories) {
		this.accessories = accessories;
	}
	
	public int getATK() {
		return this.arms.getATK();
	}

	public int getDEF() {
		return this.armor.getDEF();
	}

	public int getSPD() {
		return this.shoes.getSPD();
	}

	public double getHIT() {
		return this.accessories.getHIT();
	}

	public double getEVD() {
		return this.accessories.getEVD();
	}

	public double getCRT() {
		return this.accessories.getCRT();
	}

	public static class EquipmentBuilder{
		
		private Arms arms;
		private Armor armor;
		private Shoes shoes;
		private Accessories accessories;
		
		public EquipmentBuilder setArms(Arms arms){
			this.arms = arms;
			return this;
		}
		
		public EquipmentBuilder setArmor(Armor armor){
			this.armor = armor;
			return this;
		}
		
		public EquipmentBuilder setShoes(Shoes shoes){
			this.shoes = shoes;
			return this;
		}
		
		public EquipmentBuilder setAccessories(Accessories accessories){
			this.accessories = accessories;
			return this;
		}
		
		public Equipment build(){
			return new Equipment(this);
		}
				
	}

	public String toString() {
		return "Equipment [arms=" + arms + ", armor=" + armor + ", shoes="
				+ shoes + ", accessories=" + accessories + "]";
	}
	
}


