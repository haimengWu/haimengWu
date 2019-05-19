package com.HaimengWu.abstractFactory.enemyFactory;

import com.HaimengWu.abstractFactory.EnemyAbstarctFactory;
import com.HaimengWu.beans.Enemy;
//���˹�����
public class EnemyFactory {

	public static Enemy getEnemy(EnemyAbstarctFactory enemy){
		return enemy.createEnemy();
	}
}
