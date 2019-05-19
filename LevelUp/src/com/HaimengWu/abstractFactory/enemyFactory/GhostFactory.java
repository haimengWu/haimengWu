package com.HaimengWu.abstractFactory.enemyFactory;

import com.HaimengWu.beans.enemy.Ghost;

import com.HaimengWu.abstractFactory.EnemyAbstarctFactory;
import com.HaimengWu.beans.Enemy;
//���鹤����
public class GhostFactory implements EnemyAbstarctFactory {
	
	private int level;
	
	public GhostFactory(int level) {
		this.level = level;
	}
	
	public Enemy createEnemy(){
		return new Ghost(level);
	}
}
