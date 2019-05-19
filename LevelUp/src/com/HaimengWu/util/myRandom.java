package com.HaimengWu.util;

import java.util.Random;

import com.HaimengWu.abstractFactory.enemyFactory.*;
import com.HaimengWu.beans.Enemy;
import com.HaimengWu.state.enemy.BossState;
import com.HaimengWu.state.enemy.EnemyContext;

public class myRandom {
			
	private static Random random = new Random();
	
	public static int randomInt(int min, int max){
		return min + random.nextInt(max - min + 1) ;
	}
	
	public static double randomDouble(double min, double max){
		return min + random.nextDouble() * (max - min);
	}
	public static Enemy randomEnemy(int level){
		Enemy enemy = null;
		int lv = 1;
		if(level <= 3){
			lv = randomInt(1,level);
		}else{
			lv = randomInt(level - 3,level);
		}
		int type = randomInt(1,4);
		if(type==1){
			enemy = EnemyFactory.getEnemy(new BeastFactory(lv));    		      			
    	}else if(type==2){
    		enemy = EnemyFactory.getEnemy(new GhostFactory(lv));  
    	}else if(type==3){
    		enemy = EnemyFactory.getEnemy(new WitchFactory(lv));  
    	}else if(type==4){
    		enemy = EnemyFactory.getEnemy(new ZombieFactory(lv));  
    	}
		if(randomInt(1,7)==1){
			EnemyContext ec = new EnemyContext();
			ec.setEnemyState(new BossState());
			ec.doAction(enemy);
		}
		return enemy;
	}
}
