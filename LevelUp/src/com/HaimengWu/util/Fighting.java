package com.HaimengWu.util;

import com.HaimengWu.builder.equipment.*;
import com.HaimengWu.composite.item.potion.*;
import com.HaimengWu.strategy.attack.*;
import com.HaimengWu.beans.Enemy;
import com.HaimengWu.beans.Player;

public class Fighting {
	
	private Player player;
	private Enemy enemy;
	
	public Fighting(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
	}
	
	public String attack(Player player, Enemy enemy){
		String temp = "";
		int damage = player.getATK() + player.getEquipment().getATK() - enemy.getDEF();
		if(damage < 0){
			damage = 0;
		}
		if(isCRT(player.getCRT())){
			damage *= 1.5;
		}
		if(!isHIT(player.getHIT(),enemy.getEVD())){
			temp += player.getName() +" attacks miss, "+ enemy.getName()
					+" remains "+ enemy.getCurrentHP() + " HP\n";
			System.out.println(player.getName() +" attacks miss, "+ enemy.getName()
					+" remains "+ enemy.getCurrentHP() + " HP");
		}else{
			System.out.print(player.getName());
			temp += player.getName();
			if(myRandom.randomDouble(0, 1) > 0.4){
				damage = new BasicAttack().attack(damage);
				temp += " uses Basic Attack causing " + damage + " damage";
			}else{
				damage = new SpecialAttack().attack(damage);
				if(myRandom.randomInt(0, 100) < 10){
					temp += " uses Fatal Attack causing " + damage + " damage";
				}else{
					temp += " uses Fluctuating Attack causing " + damage + " damage";
				}
			}
			if(enemy.getCurrentHP() - damage > 0){
				enemy.setCurrentHP(enemy.getCurrentHP() - damage);
			}else{
				enemy.setCurrentHP(0);
			}
			temp += ", "+ enemy.getName()
					+" remains "+ enemy.getCurrentHP() + " HP\n";
			System.out.println(", "+ enemy.getName()
					+" remains "+ enemy.getCurrentHP() + " HP");
		}
		return temp;
	}
	
	public String attack(Enemy enemy, Player player){
		String temp = "";
		int damage = enemy.getATK() - player.getEquipment().getDEF() - player.getDEF();
		if(damage < 0){
			damage = 0;
		}
		if(isCRT(enemy.getCRT())){
			damage *= 1.5;
		}
		if(!isHIT(enemy.getHIT(),player.getEVD())){
			System.out.println(enemy.getName() +" attacks miss, "+ player.getName()
					+" remains "+ player.getCurrentHP() + " HP");
			temp += enemy.getName() +" attacks miss, "+ player.getName()
					+" remains "+ player.getCurrentHP() + " HP\n";
		}else{
		if(player.getCurrentHP() - damage > 0){
			player.setCurrentHP(player.getCurrentHP() - damage);
		}else{
			player.setCurrentHP(0);
		}
		System.out.println(enemy.getName() +" uses Basic Attack causing " + damage + " damage, "+ player.getName()
				+" remains "+ player.getCurrentHP() + " HP");
		temp += enemy.getName() +" uses Basic Attack causing " + damage + " damage, "+ player.getName()
				+" remains "+ player.getCurrentHP() + " HP\n";
		}
		return temp;
	}
	
	public String fight(){
		String detail = "";
		System.out.println("Fight Begin");
		detail += "Fight Begin\n";
		int round = 1;
		boolean isWin =false;
		while(player.getCurrentHP() > 0 && enemy.getCurrentHP() > 0){
			System.out.print("Round " + round+" : ");
			detail += "Round " + round++  +" : ";
			if(isPlayerAttack(player, enemy)){
				detail += attack(player, enemy);
			}else{
				detail += attack(enemy, player);
			}
			if(enemy.getCurrentHP()<= 0){
				System.out.println("Fight finish");
				detail += "Fight finish\n\n";
				System.out.println("***"+player.getName() +" win***\n");
				detail += "***"+player.getName() +" win***\n\n";
				isWin = true;
			}
			if(player.getCurrentHP()<= 0){
				System.out.println("Fight Finish");
				detail += "Fight finish\n\n";
				System.out.println("***"+enemy.getName() +" win***\n");
				detail += "***"+enemy.getName() +" win***\n\n";
				isWin = false;
			}			
		}
		if(isWin){
			detail  += getEXP();
			for(int i = 0;i < 4;i++){
				detail += getItem();
			}
		}
		return detail;
	}
	
	private boolean isCRT(double CRT){
		return CRT > myRandom.randomDouble(0, 1);
	}
	
	private boolean isHIT(double HIT,double EVD){
		return (1- EVD)/HIT > myRandom.randomDouble(0, 1);
	}
	
	private boolean isPlayerAttack(Player player, Enemy enemy){
		int playSPD = player.getSPD() + player.getEquipment().getSPD();
		return playSPD > myRandom.randomInt(0, playSPD + enemy.getSPD());
	}
	
	private String getEXP(){
		String temp = "";
		int EXP = 30 + enemy.getLevel() * 10 ;
		if(enemy.getIsBoss())
			EXP *= 4;
		player.setCurrentEXP(player.getCurrentEXP() + EXP);
		while(player.getCurrentEXP() >= player.getMaxEXP()){
			temp += player.levelUp() +"\n";
		}
		return temp;
	}
	private String getItem(){
		int result = myRandom.randomInt(0, 24);
		String temp = "";
		switch(result){
			case 0:
				player.addItem(new ATKPotion(enemy.getLevel()));
				System.out.println(player.getName() + " gets ATK Potion");
				temp += player.getName() + " gets ATK Potion\n";
				break;
			case 1:
				player.addItem(new CRTPotion(enemy.getLevel()));
				System.out.println(player.getName() + " gets CRT Potion");
				temp += player.getName() + " gets CRT Potion\n";
				break;
			case 2:
				player.addItem(new DEFPotion(enemy.getLevel()));
				System.out.println(player.getName() + " gets DEF Potion");
				temp += player.getName() + " gets DEF Potion\n";
				break;
			case 3:
				player.addItem(new EVDPotion(enemy.getLevel()));
				System.out.println(player.getName() + " gets EVD Potion");
				temp += player.getName() + " gets EVD Potion\n";
				break;
			case 4:
				player.addItem(new EXPPotion(enemy.getLevel()));
				System.out.println(player.getName() + " gets EXP Potion");
				temp += player.getName() + " gets EXP Potion\n";
				break;
			case 5:
				player.addItem(new HITPotion(enemy.getLevel()));
				System.out.println(player.getName() + " gets HIT Potion");
				temp += player.getName() + " gets HIT Potion\n";
				break;
			case 6:
				player.addItem(new SPDPotion(enemy.getLevel()));
				System.out.println(player.getName() + " gets ATK Potion");
				temp += player.getName() + " gets ATK Potion\n";
				break;
			case 7:
				player.addItem(new Accessories(enemy.getLevel()));
				System.out.println(player.getName() + " gets Accessories");
				temp += player.getName() + " gets Accessories\n";
				break;
			case 8:
				player.addItem(new Arms(enemy.getLevel()));
				System.out.println(player.getName() + " gets arms");
				temp += player.getName() + " gets arms\n";
				break;
			case 9:
				player.addItem(new Armor(enemy.getLevel()));
				System.out.println(player.getName() + " gets armor");
				temp += player.getName() + " gets armor\n";
				break;
			case 10:
				player.addItem(new Shoes(enemy.getLevel()));
				System.out.println(player.getName() + " gets shoes");
				temp += player.getName() + " gets shoes\n";
				break;
			case 11:
			case 12:
			case 13:
			case 14:
				player.addItem(new HPPotion(enemy.getLevel()));
				System.out.println(player.getName() + " gets HP Potion");
				temp += player.getName() + " gets HP Potion\n";
				break;
			default:
				break;
		}
		return temp;
	}
	
}
