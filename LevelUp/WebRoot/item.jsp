<%@page import="java.awt.ItemSelectable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.HaimengWu.dao.*"%>
<%@ page import="com.HaimengWu.beans.*"%>
<%@ page import="com.HaimengWu.composite.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Level Up —— Items</title>
</head>
<body>
	<form action="useItem" method="post">
		<input type="submit" value="UseAll"> 
	</form>
	<table border="1">
		<tr>
			<th>Items</th>
			<th>Id</th>
		</tr>
		<% 	Player player = (Player)request.getSession().getAttribute("player"); 
			List<Item> items = null;
			items = player.getItems();
			if(!items.isEmpty()){
			int id =1;
	        for(Item item : items){
		 %>
		<tr>
			<td><%=item%></td>	
			<td><%=id%></td>						
		</tr>
		<%id++;
			}
		} %>
	</table>   	
	<a href="game.jsp">
		<button>Back</button>
	</a>
</body>
</html>