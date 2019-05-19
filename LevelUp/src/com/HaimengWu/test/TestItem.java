package com.HaimengWu.test;

import java.util.List;

import com.HaimengWu.composite.Item;
import com.HaimengWu.composite.item.*;
import com.HaimengWu.composite.item.potion.*;
import com.HaimengWu.abstractFactory.playerFactory.*;
import com.HaimengWu.beans.Player;

public class TestItem {
//ŒÔ∆∑≤‚ ‘¿‡
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testItem();
	}
	private static void testItem(){
		Player fighter = PlayerFactory.getPlayer(new FighterFactory("Fighter"));
		
		Item potion1 = new HPPotion(1);
		
		Item potion2 = new HPPotion(5);
		fighter.addItem(potion1);
		fighter.addItem(potion2);
		
		List<Item> items = fighter.getItems();
        for(Item item : items){
        	HPPotion dp = (HPPotion)item;
        	System.out.println("HAHA"+potion1.getType());
        	System.out.println("This is a "+dp);
        }
		
		Using using = new Using();
		using.add(potion1);
		using.add(potion2);
		System.out.println("This is a "+fighter);
		fighter.displayItems();
		using.use(fighter);
		fighter.displayItems();
		System.out.println("This is a "+fighter);
		


	}
}
