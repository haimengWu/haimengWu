package com.HaimengWu.abstractFactory.enemyFactory;

import com.HaimengWu.beans.enemy.Witch;

import com.HaimengWu.abstractFactory.EnemyAbstarctFactory;
import com.HaimengWu.beans.Enemy;
//女巫工厂类
public class WitchFactory implements EnemyAbstarctFactory {
	
	private int level;
	
	public WitchFactory(int level) {
		this.level = level;
	}
	
	public Enemy createEnemy(){
		return new Witch(level);
	}
}
