package com.HaimengWu.abstractFactory.enemyFactory;

import com.HaimengWu.beans.enemy.Beast;

import com.HaimengWu.abstractFactory.EnemyAbstarctFactory;
import com.HaimengWu.beans.Enemy;
//“∞ ﬁπ§≥ß¿‡
public class BeastFactory implements EnemyAbstarctFactory {
	
	private int level;
	
	public BeastFactory(int level) {
		this.level = level;
	}
	
	public Enemy createEnemy(){
		return new Beast(level);
	}
}
