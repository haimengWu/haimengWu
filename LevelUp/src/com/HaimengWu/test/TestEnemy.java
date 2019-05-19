package com.HaimengWu.test;

import com.HaimengWu.state.enemy.*;

import com.HaimengWu.beans.Enemy;
import com.HaimengWu.abstractFactory.enemyFactory.*;
//ÕÊº“≤‚ ‘¿‡
public class TestEnemy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testEnemy();
	}
	
	private static void testEnemy(){
		Enemy beast1 = EnemyFactory.getEnemy(new BeastFactory(1));
		Enemy beast2 = EnemyFactory.getEnemy(new BeastFactory(2));
		Enemy ghost = EnemyFactory.getEnemy(new GhostFactory(1));
		Enemy witch = EnemyFactory.getEnemy(new WitchFactory(1));
		Enemy zombie = EnemyFactory.getEnemy(new ZombieFactory(1));
		System.out.println("This is a "+beast1);
		System.out.println("This is a "+beast2);
		System.out.println("This is a "+ghost);
		System.out.println("This is a "+witch);
		System.out.println("This is a "+zombie);
		EnemyContext ec = new EnemyContext();
		ec.setEnemyState(new BossState());
		ec.doAction(witch);
		System.out.println("This is a "+witch);
		ec.setEnemyState(new NormalState());
		ec.doAction(witch);
		System.out.println("This is a "+witch);
	}

}
