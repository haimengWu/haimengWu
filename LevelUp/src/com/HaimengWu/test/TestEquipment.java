package com.HaimengWu.test;

import com.HaimengWu.builder.Equipment;
import com.HaimengWu.builder.equipment.*;

import com.HaimengWu.abstractFactory.playerFactory.MageFactory;
import com.HaimengWu.abstractFactory.playerFactory.PlayerFactory;
import com.HaimengWu.beans.Player;

public class TestEquipment {
//◊∞±∏≤‚ ‘¿‡
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testEquipment();
	}
	private static void testEquipment(){
		Armor armor = new Armor(5);
		Arms arms = new Arms(5);
		Shoes shoes = new Shoes(5);
		Accessories accessories = new Accessories(5);
		Equipment equipment = new Equipment.EquipmentBuilder().setArms(arms).
				setArmor(armor).setShoes(shoes).setAccessories(accessories).build();
		
		Player mage = PlayerFactory.getPlayer(new MageFactory("Mage"));
		System.out.println(mage.getEquipment());
		
		mage.setEquipment(equipment);
		System.out.println(mage.getEquipment());
		
		Armor ar = new Armor(10);
		mage.wear(ar);
		System.out.println(mage.getEquipment());
	}
}
