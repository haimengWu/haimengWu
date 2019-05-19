<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.HaimengWu.util.*"%>
<%@ page import="com.HaimengWu.beans.*"%>
<%@ page import="java.util.*"%>
<%	
	Enemy enemy = (Enemy)request.getSession().getAttribute("enemy"); 
	Player player = (Player)request.getSession().getAttribute("player"); 
	String detail = (String)request.getSession().getAttribute("detail"); 
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
			<th colspan="4">Result</th>
		</tr>
		<tr>
			<th colspan="2">Enemy:[<%=enemy.getName()%>]</th>
			<th colspan="2">Player:[<%=player.getName()%>]</th>
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
			<td colspan="4">
				<textarea rows="30" cols="100">${detail}</textarea> 	
			</td>
		</tr>
	</table>
	<form action="revive" method="post">
		<input type="submit" value="Revive">
	</form>
	<form action="createEnemy" method="post">
		<input type="submit" value="Back">
	</form>

</body>
</html>