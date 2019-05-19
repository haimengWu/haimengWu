package com.HaimengWu.test;

import com.HaimengWu.util.Fighting;
import com.HaimengWu.abstractFactory.enemyFactory.*;
import com.HaimengWu.abstractFactory.playerFactory.*;
import com.HaimengWu.beans.Enemy;
import com.HaimengWu.beans.Player;

public class TestFight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testFight();
	}
	private static void testFight(){
		Enemy ghost = EnemyFactory.getEnemy(new GhostFactory(1));
		Player marksman = PlayerFactory.getPlayer(new MarksmanFactory("Marksman"));
		Fighting fighting = new Fighting(marksman,ghost);
		String detail = fighting.fight();
		System.out.println("--------------");
		System.out.println(detail);
		//boolean isWin = fighting.fight();
		//fighting.result(isWin);
	}
}
