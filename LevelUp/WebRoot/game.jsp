<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.HaimengWu.beans.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Level Up —— Game</title>
</head>
<body>
<p>Hello,${currentUser.getUsername()}</p> 
<p>Welcome to Level Up</p>
<p>Player[id: ${player.getId()},name: ${player.getName()}]</p>
<table>
	<tr>
		<td>
			<a href="basicAbility.jsp">
		    	<button>Basic Ability</button>
		    </a>
		</td>
	</tr>
	<tr>
		<td>
			<a href="totalAbility.jsp">
		    	<button>Total Ability</button>
		    </a>
		</td>
	</tr>
	<tr>
		<td>
			<a href="item.jsp">
			    <button>Item</button>
			</a>
		</td>
	</tr>
	<tr>
		<td>
			<a href="equipment.jsp">
			    <button>Equipment</button>
			</a>
		</td>
	</tr>
	<tr>
		<td>
			<form action="createEnemy" method="post">
				<input type="submit" value="Fighting">
			</form>
		</td>
	</tr>
	<tr>
		<td>
			<form action="saveRecord" method="post">
				<input type="submit" value="SaveRecord">
			</form>
		</td>
	</tr>
	<tr>
		<td>
			<a href="playerList.jsp">
			    <button>Back</button>
			</a>
		</td>
	</tr>
	<tr>
		<td>
			<a href="login.jsp">
			    <button>Exit</button>
			</a>
		</td>
	</tr>
</table>
</body>
</html>