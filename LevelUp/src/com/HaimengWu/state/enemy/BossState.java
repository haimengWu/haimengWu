package com.HaimengWu.state.enemy;

import com.HaimengWu.beans.Enemy;
import com.HaimengWu.state.EnemyState;
//Boss����״̬��
public class BossState implements EnemyState{
	
	public Enemy doAction(Enemy enemy) {
		enemy.boss();
		return enemy;
	}

}
