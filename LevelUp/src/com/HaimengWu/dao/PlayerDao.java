package com.HaimengWu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.HaimengWu.abstractFactory.playerFactory.*;
import com.HaimengWu.beans.Player;
import com.HaimengWu.builder.Equipment;
import com.HaimengWu.builder.equipment.*;
import com.HaimengWu.composite.Item;
import com.HaimengWu.composite.item.potion.*;
import com.HaimengWu.util.DbUtil;

public class PlayerDao {
    
	private DbUtil db = new DbUtil();
	private Connection con = null;
	
    public void createPlayer(Player player) throws SQLException{
    	try {
			con = db.getCon();
			String sql = "insert into player(name,type,level,maxHP,currentHP,maxEXP,currentEXP,"
	    			+ "ATK,DEF,SPD,HIT,EVD,CRT,isVIP,userid) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        PreparedStatement ps=con.prepareStatement(sql);//
	        ps.setString(1, player.getName());
	        ps.setString(2, player.getType());
	        ps.setInt(3,player.getLevel());
	        ps.setInt(4,player.getMaxHP());
	        ps.setInt(5,player.getCurrentHP());
	        ps.setInt(6,player.getMaxEXP());
	        ps.setInt(7,player.getCurrentEXP());
	        ps.setInt(8,player.getATK());
	        ps.setInt(9,player.getDEF());
	        ps.setInt(10,player.getSPD());
	        ps.setDouble(11,player.getHIT());
	        ps.setDouble(12,player.getEVD());
	        ps.setDouble(13,player.getCRT());
	        if(player.isVIP()){
	        	ps.setInt(14,1);
	        }else{
	        	ps.setInt(14,0);
	        }
	        ps.setInt(15,player.getUserId());
	        ps.execute();
	        
	        Player p = findByName(player.getName());
	        
	        Equipment equipment = player.getEquipment();
	        Arms arms = equipment.getArms();
	        Armor armor = equipment.getArmor();
	        Shoes shoes = equipment.getShoes();
	        Accessories accessories = equipment.getAccessories();
	        
	        String sql2 = "insert into equipment(userid,playerid,type,level,ATK) values(?,?,?,?,?)";
	        ps=con.prepareStatement(sql2);//
	        ps.setInt(1, p.getUserId());
	        ps.setInt(2, p.getId());
	        ps.setString(3,arms.getType());
	        ps.setInt(4,arms.getLevel());
	        ps.setInt(5,arms.getATK());
	        ps.execute();
	        
	        String sql3 = "insert into equipment(userid,playerid,type,level,DEF) values(?,?,?,?,?)";
	        ps=con.prepareStatement(sql3);//
	        ps.setInt(1, p.getUserId());
	        ps.setInt(2, p.getId());
	        ps.setString(3,armor.getType());
	        ps.setInt(4,armor.getLevel());
	        ps.setInt(5,armor.getDEF());
	        ps.execute();
	        
	        String sql4 = "insert into equipment(userid,playerid,type,level,HIT,EVD,CRT) values(?,?,?,?,?,?,?)";
	        ps=con.prepareStatement(sql4);//
	        ps.setInt(1, p.getUserId());
	        ps.setInt(2, p.getId());
	        ps.setString(3,accessories.getType());
	        ps.setInt(4,accessories.getLevel());
	        ps.setDouble(5,accessories.getHIT());
	        ps.setDouble(6,accessories.getEVD());
	        ps.setDouble(7,accessories.getCRT());
	        ps.execute();
	        
	        String sql5 = "insert into equipment(userid,playerid,type,level,SPD) values(?,?,?,?,?)";
	        ps=con.prepareStatement(sql5);//
	        ps.setInt(1, p.getUserId());
	        ps.setInt(2, p.getId());
	        ps.setString(3,shoes.getType());
	        ps.setInt(4,shoes.getLevel());
	        ps.setInt(5,shoes.getSPD());
	        ps.execute();
	        }	        
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return;
    }
    
    public Player findByName(String name) throws SQLException{
    	Player player=null;
		try {
			con = db.getCon();
			String sql = "select * from player where name=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
	        ResultSet rs=ps.executeQuery();
	        if(rs.next()){
	        	String type = rs.getString("type");
	        	if(type.equals("Fighter")){
	        		player = PlayerFactory.getPlayer(new FighterFactory(rs.getString("name")));        		      			
	        	}else if(type.equals("Mage")){
	        		player = PlayerFactory.getPlayer(new MageFactory(rs.getString("name")));
	        	}else if(type.equals("Marksman")){
	        		player = PlayerFactory.getPlayer(new MarksmanFactory(rs.getString("name")));
	        	}else if(type.equals("Assassin")){
	        		player = PlayerFactory.getPlayer(new AssassinFactory(rs.getString("name")));
	        	}
	        	player.setUserId(rs.getInt("userId"));
	        	player.setId(rs.getInt("id"));
	        	player.setName(rs.getString("name"));
	        	player.setType(rs.getString("type"));
	        	player.setLevel(rs.getInt("level"));
	        	player.setMaxHP(rs.getInt("maxHP"));
	        	player.setCurrentHP(rs.getInt("currentHP"));
	        	player.setMaxEXP(rs.getInt("maxEXP"));
	        	player.setCurrentEXP(rs.getInt("currentEXP"));
	        	player.setATK(rs.getInt("ATK"));
	        	player.setDEF(rs.getInt("DEF"));
	        	player.setSPD(rs.getInt("SPD"));
	        	player.setEVD(rs.getDouble("EVD"));
	        	player.setHIT(rs.getDouble("HIT"));
	        	player.setCRT(rs.getDouble("CRT"));
	        	if(rs.getInt("isVIP")==0){
	        		player.setVIP(false);
	        	}else if(rs.getInt("isVIP")==1){
	        		player.setVIP(true);
	        	}
	        	
	        	Equipment equipment = player.getEquipment();
		        Arms arms = equipment.getArms();
		        Armor armor = equipment.getArmor();
		        Shoes shoes = equipment.getShoes();
		        Accessories accessories = equipment.getAccessories();
		        String sql1 = "select * from equipment where userid=? and playerid=?";
				ps = con.prepareStatement(sql1);
				ps.setInt(1, player.getUserId());
				ps.setInt(2, player.getId());
		        rs=ps.executeQuery();
		        while(rs.next()){
		        	if(rs.getString("type").equals("arms")){
			        	arms.setATK(rs.getInt("ATK"));
			        	arms.setLevel(rs.getInt("level"));
		        	}else if(rs.getString("type").equals("armor")){
		        		armor.setDEF(rs.getInt("DEF"));
			        	armor.setLevel(rs.getInt("level"));
		        	}else if(rs.getString("type").equals("shoes")){
		        		shoes.setSPD(rs.getInt("SPD"));
			        	shoes.setLevel(rs.getInt("level"));
		        	}else if(rs.getString("type").equals("accessories")){
		        		accessories.setHIT(rs.getDouble("HIT"));
		        		accessories.setCRT(rs.getDouble("CRT"));
		        		accessories.setEVD(rs.getDouble("EVD"));
		        		accessories.setLevel(rs.getInt("level"));
		        	}
		        }
		        player.wear(accessories);
		        player.wear(arms);
		        player.wear(armor);
		        player.wear(shoes);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return player;  
    }
    
    public Player findById(int id) throws SQLException{
    	Player player=null;
		try {
			con = db.getCon();
			String sql = "select * from player where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
	        ResultSet rs=ps.executeQuery();
	        if(rs.next()){
	        	String type = rs.getString("type");
	        	if(type.equals("Fighter")){
	        		player = PlayerFactory.getPlayer(new FighterFactory(rs.getString("name")));        		      			
	        	}else if(type.equals("Mage")){
	        		player = PlayerFactory.getPlayer(new MageFactory(rs.getString("name")));
	        	}else if(type.equals("Marksman")){
	        		player = PlayerFactory.getPlayer(new MarksmanFactory(rs.getString("name")));
	        	}else if(type.equals("Assassin")){
	        		player = PlayerFactory.getPlayer(new AssassinFactory(rs.getString("name")));
	        	}
	        	player.setUserId(rs.getInt("userId"));
	        	player.setId(rs.getInt("id"));
	        	player.setName(rs.getString("name"));
	        	player.setType(rs.getString("type"));
	        	player.setLevel(rs.getInt("level"));
	        	player.setMaxHP(rs.getInt("maxHP"));
	        	player.setCurrentHP(rs.getInt("currentHP"));
	        	player.setMaxEXP(rs.getInt("maxEXP"));
	        	player.setCurrentEXP(rs.getInt("currentEXP"));
	        	player.setATK(rs.getInt("ATK"));
	        	player.setDEF(rs.getInt("DEF"));
	        	player.setSPD(rs.getInt("SPD"));
	        	player.setEVD(rs.getDouble("EVD"));
	        	player.setHIT(rs.getDouble("HIT"));
	        	player.setCRT(rs.getDouble("CRT"));
	        	if(rs.getInt("isVIP")==0){
	        		player.setVIP(false);
	        	}else if(rs.getInt("isVIP")==1){
	        		player.setVIP(true);
	        	}	        	
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return player;  
    }

    public List<Player> findAllByUserId(int userId) throws SQLException {
    	List<Player> lp = new ArrayList<Player>();
    	try {
			con = db.getCon();
			String sql = "select * from player where userid ='"+userId+"'";
			PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs=ps.executeQuery();
	        while(rs.next()){
	        	Player player = null;
	        	String type = rs.getString("type");
	        	if(type.equals("Fighter")){
	        		player = PlayerFactory.getPlayer(new FighterFactory(rs.getString("name")));        		      			
	        	}else if(type.equals("Mage")){
	        		player = PlayerFactory.getPlayer(new MageFactory(rs.getString("name")));
	        	}else if(type.equals("Marksman")){
	        		player = PlayerFactory.getPlayer(new MarksmanFactory(rs.getString("name")));
	        	}else if(type.equals("Assassin")){
	        		player = PlayerFactory.getPlayer(new AssassinFactory(rs.getString("name")));
	        	}
	        	player.setUserId(rs.getInt("userId"));
	        	player.setId(rs.getInt("id"));
	        	player.setName(rs.getString("name"));
	        	player.setType(rs.getString("type"));
	        	player.setLevel(rs.getInt("level"));
	        	player.setMaxHP(rs.getInt("maxHP"));
	        	player.setCurrentHP(rs.getInt("currentHP"));
	        	player.setMaxEXP(rs.getInt("maxEXP"));
	        	player.setCurrentEXP(rs.getInt("currentEXP"));
	        	player.setATK(rs.getInt("ATK"));
	        	player.setDEF(rs.getInt("DEF"));
	        	player.setSPD(rs.getInt("SPD"));
	        	player.setEVD(rs.getDouble("EVD"));
	        	player.setHIT(rs.getDouble("HIT"));
	        	player.setCRT(rs.getDouble("CRT"));
	        	if(rs.getInt("isVIP")==0){
	        		player.setVIP(false);
	        	}else if(rs.getInt("isVIP")==1){
	        		player.setVIP(true);
	        	}
	        	lp.add(player);
	        	}
    		}
        catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        return lp;
	}
    
    public List<Player> findAll() throws SQLException {
    	List<Player> lp = new ArrayList<Player>();
    	try {
			con = db.getCon();
			String sql = "select * from player";
			PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs=ps.executeQuery();
	        while(rs.next()){
	        	Player player = null;
	        	String type = rs.getString("type");
	        	if(type.equals("Fighter")){
	        		player = PlayerFactory.getPlayer(new FighterFactory(rs.getString("name")));        		      			
	        	}else if(type.equals("Mage")){
	        		player = PlayerFactory.getPlayer(new MageFactory(rs.getString("name")));
	        	}else if(type.equals("Marksman")){
	        		player = PlayerFactory.getPlayer(new MarksmanFactory(rs.getString("name")));
	        	}else if(type.equals("Assassin")){
	        		player = PlayerFactory.getPlayer(new AssassinFactory(rs.getString("name")));
	        	}
	        	player.setUserId(rs.getInt("userId"));
	        	player.setId(rs.getInt("id"));
	        	player.setName(rs.getString("name"));
	        	player.setType(rs.getString("type"));
	        	player.setLevel(rs.getInt("level"));
	        	player.setMaxHP(rs.getInt("maxHP"));
	        	player.setCurrentHP(rs.getInt("currentHP"));
	        	player.setMaxEXP(rs.getInt("maxEXP"));
	        	player.setCurrentEXP(rs.getInt("currentEXP"));
	        	player.setATK(rs.getInt("ATK"));
	        	player.setDEF(rs.getInt("DEF"));
	        	player.setSPD(rs.getInt("SPD"));
	        	player.setEVD(rs.getDouble("EVD"));
	        	player.setHIT(rs.getDouble("HIT"));
	        	player.setCRT(rs.getDouble("CRT"));
	        	if(rs.getInt("isVIP")==0){
	        		player.setVIP(false);
	        	}else if(rs.getInt("isVIP")==1){
	        		player.setVIP(true);
	        	}
	        	lp.add(player);
	        	}
    		}
        catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
        return lp;
	}
    
    public void updatePlayer(Player player) throws SQLException{
    	try {
			con = db.getCon();
			String sql= "update player set name=?, type=?, level=?, maxHP=?, currentHP=?, maxEXP=?, currentEXP=?, "
	    			+ "ATK=?, DEF=?, SPD=?, HIT=?, EVD=?, CRT=?, isVIP=? where id = ?";
	        PreparedStatement ps=con.prepareStatement(sql);//
	        ps.setString(1, player.getName());
	        ps.setString(2, player.getType());
	        ps.setInt(3,player.getLevel());
	        ps.setInt(4,player.getMaxHP());
	        ps.setInt(5,player.getCurrentHP());
	        ps.setInt(6,player.getMaxEXP());
	        ps.setInt(7,player.getCurrentEXP());
	        ps.setInt(8,player.getATK());
	        ps.setInt(9,player.getDEF());
	        ps.setInt(10,player.getSPD());
	        ps.setDouble(11,player.getHIT());
	        ps.setDouble(12,player.getEVD());
	        ps.setDouble(13,player.getCRT());	        
	        if(player.isVIP()){
	        	ps.setInt(14,1);
	        }else{
	        	ps.setInt(14,0);
	        }
	        ps.setInt(15,player.getId());
	        ps.execute();
	        
	        Player p = findByName(player.getName());
	        
	        Equipment equipment = player.getEquipment();
	        Arms arms = equipment.getArms();
	        Armor armor = equipment.getArmor();
	        Shoes shoes = equipment.getShoes();
	        Accessories accessories = equipment.getAccessories();
	        
	        String sql2 = "update equipment set level=?,ATK=? where userid=? and playerid=? and type=?";
	        ps=con.prepareStatement(sql2);//        
	        ps.setInt(1,arms.getLevel());
	        ps.setInt(2,arms.getATK());
	        ps.setInt(3, p.getUserId());
	        ps.setInt(4, p.getId());
	        ps.setString(5,arms.getType());
	        ps.execute();
	        
	        String sql3 = "update equipment set level=?,DEF=? where userid=? and playerid=? and type=?";
	        ps=con.prepareStatement(sql3);//        
	        ps.setInt(1,armor.getLevel());
	        ps.setInt(2,armor.getDEF());
	        ps.setInt(3, p.getUserId());
	        ps.setInt(4, p.getId());
	        ps.setString(5,armor.getType());
	        ps.execute();
	        
	        String sql4 = "update equipment set level=?,SPD=? where userid=? and playerid=? and type=?";
	        ps=con.prepareStatement(sql4);//        
	        ps.setInt(1,shoes.getLevel());
	        ps.setInt(2,shoes.getSPD());
	        ps.setInt(3, p.getUserId());
	        ps.setInt(4, p.getId());
	        ps.setString(5,shoes.getType());
	        ps.execute();
	        
	        String sql5 = "update equipment set level=?,HIT=?,EVD=?,CRT=? where userid=? and playerid=? and type=?";
	        ps=con.prepareStatement(sql5);//
	        ps.setInt(1,accessories.getLevel());
	        ps.setDouble(2,accessories.getHIT());
	        ps.setDouble(3,accessories.getEVD());
	        ps.setDouble(4,accessories.getCRT());
	        ps.setInt(5, p.getUserId());
	        ps.setInt(6, p.getId());
	        ps.setString(7,accessories.getType());
	        ps.execute();
	            
	        String sql6 = "delete from item where playerid = ?";
			ps=con.prepareStatement(sql6);
			ps.setInt(1, player.getId());
	        ps.execute();
	        
	        List<Item> items = player.getItems();
	        for(Item item : items){
	        	if(item.getType().equals("ATKPotion")){	
		        	ATKPotion ap = (ATKPotion)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,ATK) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, ap.getType());
			        ps.setInt(4, ap.getLevel());
			        ps.setInt(5,ap.getATK());
			        ps.execute();
	        	}else if(item.getType().equals("CRTPotion")){
	        		CRTPotion cp = (CRTPotion)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,CRT) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, cp.getType());
			        ps.setInt(4, cp.getLevel());
			        ps.setDouble(5,cp.getCRT());
			        ps.execute();
	        	}else if(item.getType().equals("DEFPotion")){
	        		DEFPotion dp = (DEFPotion)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,DEF) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, dp.getType());
			        ps.setInt(4, dp.getLevel());
			        ps.setInt(5,dp.getDEF());
			        ps.execute();
	        	}else if(item.getType().equals("EVDPotion")){
	        		EVDPotion ep = (EVDPotion)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,EVD) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, ep.getType());
			        ps.setInt(4, ep.getLevel());
			        ps.setDouble(5,ep.getEVD());
			        ps.execute();
	        	}else if(item.getType().equals("EXPPotion")){
	        		EXPPotion ep = (EXPPotion)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,EXP) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, ep.getType());
			        ps.setInt(4, ep.getLevel());
			        ps.setInt(5,ep.getEXP());
			        ps.execute();
	        	}else if(item.getType().equals("HITPotion")){
	        		HITPotion hp = (HITPotion)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,HIT) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, hp.getType());
			        ps.setInt(4, hp.getLevel());
			        ps.setDouble(5,hp.getHIT());
			        ps.execute();
	        	}else if(item.getType().equals("HPPotion")){
	        		HPPotion hp = (HPPotion)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,HP) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, hp.getType());
			        ps.setInt(4, hp.getLevel());
			        ps.setInt(5,hp.getHP());
			        ps.execute();
	        	}else if(item.getType().equals("SPDPotion")){
	        		SPDPotion sp = (SPDPotion)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,SPD) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, sp.getType());
			        ps.setInt(4, sp.getLevel());
			        ps.setInt(5,sp.getSPD());
			        ps.execute();
	        	}else if(item.getType().equals("Armor")){
	        		Armor sp = (Armor)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,DEF) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, sp.getType());
			        ps.setInt(4, sp.getLevel());
			        ps.setInt(5,sp.getDEF());
			        ps.execute();
	        	}else if(item.getType().equals("Arms")){
	        		Arms sp = (Arms)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,ATK) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, sp.getType());
			        ps.setInt(4, sp.getLevel());
			        ps.setInt(5,sp.getATK());
			        ps.execute();
	        	}else if(item.getType().equals("Shoes")){
	        		Shoes sp = (Shoes)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,SPD) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, sp.getType());
			        ps.setInt(4, sp.getLevel());
			        ps.setInt(5,sp.getSPD());
			        ps.execute();
	        	}else if(item.getType().equals("Accessories")){
	        		Accessories sp = (Accessories)item;
		        	String sql7 = "insert into item(userid,playerid,type,level,HIT,EVD,CRT) values(?,?,?,?,?)";
			        ps=con.prepareStatement(sql7);
			        ps.setInt(1,p.getUserId());
			        ps.setInt(2,p.getId());
			        ps.setString(3, sp.getType());
			        ps.setInt(4, sp.getLevel());
			        ps.setDouble(5,sp.getHIT());
			        ps.setDouble(6,sp.getEVD());
			        ps.setDouble(7,sp.getCRT());
			        ps.execute();
	        	}
	        }
    	}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   	
        return;
    }
    
    public void deletePlayer(Player player) throws SQLException{
    	try {
			con = db.getCon();
			String sql= "delete from player where id = ?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, player.getId());
	        ps.execute();
	        
	        String sql2 = "delete from equipment where playerid = ?";
			ps=con.prepareStatement(sql2);
			ps.setInt(1, player.getId());
	        ps.execute();
	        
	        String sql3 = "delete from item where playerid = ?";
			ps=con.prepareStatement(sql3);
			ps.setInt(1, player.getId());
	        ps.execute();
	        }
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
    }
    
}
