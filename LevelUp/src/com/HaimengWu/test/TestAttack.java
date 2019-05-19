package com.HaimengWu.test;

import com.HaimengWu.strategy.attack.*;

public class TestAttack {

	public static void main(String[] args){
		// TODO Auto-generated constructor stub
		testAttack();
	}
	
	private static void testAttack(){		
		int damage = 100;
		new BasicAttack().attack(damage);		
		new SpecialAttack().attack(damage);
	}

}
