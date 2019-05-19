package com.HaimengWu.composite.item;

import java.util.*;

import com.HaimengWu.beans.Player;
import com.HaimengWu.composite.Item;

public class Using extends Item{

	private List<Item> items = new ArrayList<Item>();
	
	public void use(Player player) {
		
		for(Item item : player.getItems())
		{
			item.use(player);
		}
		System.out.println("All items are using by " + player.getName());
	}
	public void add(Item item){
		this.items.add(item);
	}
	
	public void remove(Item item){
		items.remove(item);
	}
	
	public void clear(){
		this.items.clear();
	}
}
