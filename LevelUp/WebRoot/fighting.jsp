<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.HaimengWu.util.*"%>
<%@ page import="com.HaimengWu.beans.*"%>
<%@ page import="java.util.*"%>
<%	
	Enemy enemy = (Enemy)request.getSession().getAttribute("enemy"); 
	Player player = (Player)request.getSession().getAttribute("player"); 
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Level Up —— fighting</title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="2">Enemy:[<%=enemy.getName()%>]</th>
			<th colspan="2">Player:[<%=player.getName()%>]</th>
		</tr>		
		<tr>
			<td>level</td><td><%=enemy.getLevel()%></td>
			<td>level</td><td><%=player.getLevel()%></td>
		</tr>
		<tr>
			<td>name</td><td><%=enemy.getName()%></td>
			<td>name</td><td><%=player.getName()%></td>
		</tr>
		<tr>
			<td>isBoss</td><td><%=enemy.getIsBoss()%></td>
			<td>type</td><td><%=player.getType()%></td>
		</tr>
		<tr>
			<td>maxHP</td><td><%=enemy.getMaxHP()%></td>	
			<td>maxHP</td><td><%=player.getMaxHP()%></td>						
		</tr>
		<tr>
			<td>currentHP</td><td><%=enemy.getCurrentHP()%></td>
			<td>currentHP</td><td><%=player.getCurrentHP()%></td>
		</tr>
		<tr>
			<td>ATK</td><td><%=enemy.getATK()%></td>
			<td>ATK</td><td><%=player.getATK()+player.getEquipment().getArms().getATK()%></td>							
		</tr>
		<tr>
			<td>DEF</td><td><%=enemy.getDEF()%></td>
			<td>DEF</td><td><%=player.getDEF()+player.getEquipment().getArmor().getDEF()%></td>	
		</tr>
		<tr>
			<td>SPD</td><td><%=enemy.getSPD()%></td>
			<td>SPD</td><td><%=player.getSPD()+player.getEquipment().getShoes().getSPD()%></td>	
		</tr>
		<tr>
			<td>HIT</td><td><%=enemy.getHIT()%></td>
			<td>HIT</td><td><%=player.getHIT()+player.getEquipment().getAccessories().getHIT()%></td>
		</tr>
		<tr>
			<td>EVD</td><td><%=enemy.getEVD()%></td>
			<td>EVD</td><td><%=player.getEVD()+player.getEquipment().getAccessories().getEVD()%></td>
		</tr>
		<tr>
			<td>CRT</td><td><%=enemy.getCRT()%></td>
			<td>CRT</td><td><%=player.getCRT()+player.getEquipment().getAccessories().getCRT()%></td>
		</tr>
		<tr>
			<td colspan="2"/>
			<td>maxEXP</td><td><%=player.getMaxEXP()%></td>
		</tr>
		<tr>
			<td colspan="2"/>
			<td>currentEXP</td><td><%=player.getCurrentEXP()%></td>
		</tr>
	</table>
	
	<form action="fighting" method="post">
		<input type="submit" value="Fight">
	</form> 
	<form action="createEnemy" method="post">
		<input type="submit" value="Next">
	</form>
		<form action="revive" method="post">
		<input type="submit" value="Revive">
	</form>   	
	<a href="game.jsp">
		<button>Back</button>
	</a>
</body>
</html>