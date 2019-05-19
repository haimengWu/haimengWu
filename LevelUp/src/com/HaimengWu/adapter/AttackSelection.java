package com.HaimengWu.adapter;

//¹¥»÷ÊµÌåÀà
public class AttackSelection implements Attack{
	
	private AttackAdapter attackAdapter;
	
	public void attack(String attackType) {
		attackAdapter = new AttackAdapter(attackType);
		attackAdapter.attack(attackType);
	}
	
}
