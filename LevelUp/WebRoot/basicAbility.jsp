<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.HaimengWu.dao.*"%>
<%@ page import="com.HaimengWu.beans.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Level Up —— Player detail</title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="2">Basic Ability</th>
		</tr>
		<tr>
			<td>id</td><td>${player.getId()}</td>							
		</tr>
		<tr>
			<td>name</td><td>${player.getName()}</td>
		</tr>
		<tr>
			<td>level</td><td>${player.getLevel()}</td>
		</tr>
		<tr>
			<td>type</td><td>${player.getType()}</td>
		</tr>
		<tr>
			<td>maxHP</td><td>${player.getMaxHP()}</td>							
		</tr>
		<tr>
			<td>currentHP</td><td>${player.getCurrentHP()}</td>
		</tr>
		<tr>
			<td>maxEXP</td><td>${player.getMaxEXP()}</td>
		</tr>
		<tr>
			<td>currentEXP</td><td>${player.getCurrentEXP()}</td>
		</tr>
		<tr>
			<td>ATK</td><td>${player.getATK()}</td>							
		</tr>
		<tr>
			<td>DEF</td><td>${player.getDEF()}</td>
		</tr>
		<tr>
			<td>SPD</td><td>${player.getSPD()}</td>
		</tr>
		<tr>
			<td>HIT</td><td>${player.getHIT()}</td>
		</tr>
				<tr>
			<td>EVD</td><td>${player.getEVD()}</td>
		</tr>
		<tr>
			<td>CRT</td><td>${player.getCRT()}</td>
		</tr>
	</table>   	
	<a href="game.jsp">
		<button>Back</button>
	</a>
</body>
</html>