package com.HaimengWu.abstractFactory.enemyFactory;

import com.HaimengWu.beans.enemy.Ghost;

import com.HaimengWu.abstractFactory.EnemyAbstarctFactory;
import com.HaimengWu.beans.Enemy;
//”ƒ¡Èπ§≥ß¿‡
public class GhostFactory implements EnemyAbstarctFactory {
	
	private int level;
	
	public GhostFactory(int level) {
		this.level = level;
	}
	
	public Enemy createEnemy(){
		return new Ghost(level);
	}
}
