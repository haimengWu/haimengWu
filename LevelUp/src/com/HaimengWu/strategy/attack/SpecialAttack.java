package com.HaimengWu.strategy.attack;

import com.HaimengWu.strategy.AttackStrategy;
import com.HaimengWu.util.myRandom;
import com.HaimengWu.adapter.AttackSelection;

public class SpecialAttack implements AttackStrategy{
	
	private AttackSelection attackSelection = new AttackSelection();
	public int attack(int damage) {
		// TODO Auto-generated method stub
		if(myRandom.randomInt(0, 100) < 10){
			attackSelection.attack("fatalAttack");
			damage *= 2;		
		}else{
			attackSelection.attack("fluctuatingAttack");
			damage *= myRandom.randomDouble(0.95, 1.25);
		}System.out.print("causing " + damage + " damage");
		return damage;
	}

}
