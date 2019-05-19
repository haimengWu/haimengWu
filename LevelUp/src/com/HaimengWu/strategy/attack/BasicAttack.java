package com.HaimengWu.strategy.attack;

import com.HaimengWu.strategy.AttackStrategy;

public class BasicAttack implements AttackStrategy{
	
	public int attack(int damage) {
		// TODO Auto-generated method stub
		System.out.print(" uses Basic Attack causing " + damage + " damage");
		return damage;
	}

}
