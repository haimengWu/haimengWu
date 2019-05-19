package com.HaimengWu.state.enemy;

import com.HaimengWu.beans.Enemy;
import com.HaimengWu.state.EnemyState;

public class EnemyContext {
	
	private EnemyState enemyState = null;
	
	public Enemy doAction(Enemy enemy) {
		return enemyState.doAction(enemy);
	}
	
	public EnemyState getEnemyState() {
		return enemyState;
	}
	public void setEnemyState(EnemyState enemyState) {
		this.enemyState = enemyState;
	}

}
