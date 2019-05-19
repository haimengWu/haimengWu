package com.HaimengWu.abstractFactory.enemyFactory;

import com.HaimengWu.beans.enemy.Zombie;

import com.HaimengWu.abstractFactory.EnemyAbstarctFactory;
import com.HaimengWu.beans.Enemy;
//Ω© ¨π§≥ß¿‡
public class ZombieFactory implements EnemyAbstarctFactory {
	
	private int level;
	
	public ZombieFactory(int level) {
		this.level = level;
	}
	
	public Enemy createEnemy(){
		return new Zombie(level);
	}
}
