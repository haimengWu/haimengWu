<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.HaimengWu.controller.*"%>
<%@ page import="com.HaimengWu.beans.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Level Up —— Player List</title>
</head>
<body>
<p>Hello,${currentUser.getUsername()}</p>
<p>Welcome to Level Up</p>
	<table border="1">
		<tr>
			<th colspan="5">Player List</th>
		</tr>
		<tr>
			<td>id</td>
			<td>name</td>
			<td>level</td>
			<td>type</td>
			<td>     </td>
		</tr>
			<% 	        
			PlayerController pc = new PlayerController();
			User user =(User)request.getSession().getAttribute("currentUser");
			int userId = user.getId();
			List<Player> lp = null;
			lp = pc.findAllByUserId(userId);			
			for(Player player : lp){
			%>
		<tr>
			<td><%=player.getId()%></td>
			<td><%=player.getName()%></td>
			<td><%=player.getLevel()%></td>
			<td><%=player.getType()%></td>
			<% String playername = player.getName();%>
			<td>
				<form action="selectPlayer" method="post">
					<input type="hidden" id="playername" name="playername" value="<%=playername%>"> 
					<input type="submit" value="Enter"> 
				</form>
			</td>
			<td>
				<form action="deletePlayer" method="post">
					<input type="hidden" id="playername" name="playername" value="<%=playername%>"> 
					<input type="submit" value="Delete"> 
				</form>
			</td>
			<% }%>
	</table> 
	
	<table>
		<tr>
			<td> 
				<a href="createPlayer.jsp">
					<button>Create Player</button>
				</a>
			</td>
		</tr>
		<tr>
			<td> 	
				<a href="main.jsp">
					<button>Back</button>
				</a>
			</td>
		</tr>
	</table>
</body>
</html>