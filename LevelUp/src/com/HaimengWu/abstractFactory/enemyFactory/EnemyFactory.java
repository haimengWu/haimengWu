package com.HaimengWu.abstractFactory.enemyFactory;

import com.HaimengWu.abstractFactory.EnemyAbstarctFactory;
import com.HaimengWu.beans.Enemy;
//敌人工厂类
public class EnemyFactory {

	public static Enemy getEnemy(EnemyAbstarctFactory enemy){
		return enemy.createEnemy();
	}
}
