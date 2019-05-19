<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Level Up —— Create Player</title>
</head>
<body>
<p>Hello,${currentUser.getUsername()}</p>

<p>Welcome to Level Up</p>
<form action="createPlayer" method="post">
    <table>
        <tr>
            <th colspan="2">Create Player</th>
        </tr>
        <tr>
            <td><input type="hidden" id="userId" name="userId" value="${userId}"></td>
        </tr>
        <tr>
            <td>name</td>
            <td><input type="text" id="playername" name="playername" value="${playername}"></td>
        </tr>
        <tr>
            <td>type</td>
            <td><select name="type">
					<option value="Fighter">Fighter</option>
					<option value="Mage">Mage</option>
					<option value="Marksman">Marksman</option>
					<option value="Assassin">Assassin</option>
				</select>
			</td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
<a href="main.jsp">
	<button>Back</button>
</a>

</body>
</html>