package com.HaimengWu.adapter;

import com.HaimengWu.adapter.attack.*;
//π•ª˜  ≈‰∆˜¿‡
public class AttackAdapter implements Attack{
	
	private SpecialAttack specialAttack;

	public AttackAdapter(String attackType) {
		// TODO Auto-generated constructor stub
		if(attackType.equals("fluctuatingAttack")){
			specialAttack = new FluctuatingAttack();
		}else if(attackType.equals("fatalAttack")){
			specialAttack = new FatalAttack();
		}
	}
	public void attack(String attackType){
		if(attackType.equals("fluctuatingAttack")){
			specialAttack.fluctuatingAttack();
		}else if(attackType.equals("fatalAttack")){
			specialAttack.fatalAttack();
		}
	}
}
