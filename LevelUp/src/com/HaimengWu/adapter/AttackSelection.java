package com.HaimengWu.adapter;

//����ʵ����
public class AttackSelection implements Attack{
	
	private AttackAdapter attackAdapter;
	
	public void attack(String attackType) {
		attackAdapter = new AttackAdapter(attackType);
		attackAdapter.attack(attackType);
	}
	
}
