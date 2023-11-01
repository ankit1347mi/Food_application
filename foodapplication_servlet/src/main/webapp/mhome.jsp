<%@page import="com.ty.food_application_hibernate.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.food_application_hibernate.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Login Page</title>
<style>
body {
	color: white;
	padding-top: 20px;
	padding-left: 100px;
	background-image:
		url("https://cdn.pixabay.com/photo/2023/10/09/07/23/industry-8303482_1280.jpg");
}

.anc {
	align-content: center;
	color: white;
	padding: 15px 25px;
	text-decoration: none;
	background-color: rgba(11, 13, 12, 0.5);
}

.abc {
	align-content: center;
	color: white;
	padding: 15px 25px;
	text-decoration: none;
	background-color: rgba(11, 13, 12, 0.5);
	margin-left: 85%;
}

table {
	padding: 4px;
}
</style>
</head>
<body>
	<h1>Manager Home Page</h1>
	<a href="Login.jsp" class="abc">Logout</a>
	<%
	User user1 = (User) request.getAttribute("user");
	long phone = user1.getPhone();
	%>

	<h1>
		<span>Welcome <%=user1.getName()%></span>
	</h1>
	<br>
	<br>
	<a href="signup.jsp" class="anc">Add User</a>
	<a href="createmenu.jsp" class="anc">Open Menu</a>
	<br>
	<br>
	<hr>
	<br>
	<br>

	<%
	UserDao dao = new UserDao();
	List<User> users = dao.findAllUser();
	%>
	<table border="2px solid">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Phone</td>
			<td>Role</td>
			<td>Remove</td>

		</tr>

		<%
		for (User user : users) {
		%>
		<tr>

			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getPhone()%></td>
			<td><%=user.getRole()%></td>
			<td><a href="deleteuser?id=<%=user.getId()%>"><button>Remove</button></a></td>

		</tr>
		<%
		}
		%>
	</table>



</body>
</html>