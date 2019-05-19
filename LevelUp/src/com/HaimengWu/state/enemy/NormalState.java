package com.HaimengWu.state.enemy;

import com.HaimengWu.beans.Enemy;
import com.HaimengWu.state.EnemyState;
//ÆÕÍ¨µĞÈË×´Ì¬Àà
public class NormalState implements EnemyState{

	@Override
	public Enemy doAction(Enemy enemy) {
		enemy.normal();
		return enemy;
	}

}
