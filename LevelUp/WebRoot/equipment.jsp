<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.HaimengWu.dao.*"%>
<%@ page import="com.HaimengWu.beans.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Level Up —— Equipment</title>
</head>
<body>
	<table border="1">
		<tr>
			<th colspan="2">Equipment</th>
		</tr>
		<tr>
			<td>${player.getEquipment().getArms()}</td>							
		</tr>
		<tr>
			<td>${player.getEquipment().getArmor()}</td>
		</tr>
		<tr>
			<td>${player.getEquipment().getShoes()}</td>
		</tr>
		<tr>
			<td>${player.getEquipment().getAccessories()}</td>
		</tr>
	</table>   	
	<a href="game.jsp">
		<button>Back</button>
	</a>
</body>
</html>