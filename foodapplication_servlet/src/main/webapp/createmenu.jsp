<%@page import="com.ty.food_application_hibernate.dto.FoodProduct"%>
<%@page import="com.ty.food_application_hibernate.dao.FoodProductDao"%>
<%@page import="com.ty.food_application_hibernate.dto.Menu"%>
<%@page import="com.ty.food_application_hibernate.dao.MenuDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<style>
body {
	color: white; padding-top : 20px;
	padding-left: 100px;
	background-image:
		url("https://cdn.pixabay.com/photo/2014/06/11/17/00/food-366875_640.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	padding-top: 20px;
}

.anc {
	align-content: center;
	color: white;
	padding: 15px 25px;
	text-decoration: none;
	background-color: rgba(11, 13, 12, 0.5);
}

.and {
	align-content: center;
	color: white;
	padding: 15px 25px;
	text-decoration: none;
	background-color: rgba(11, 13, 12, 0.5);
	margin-left: 65%;
}

table {
	padding: 4px;
}
</style>
</head>
<body>

	<a href="addmenu.jsp" class="anc">Add Menu</a>
	<a href="mhome.jsp" class="and">Back</a>
	<br>
	<br>
	<hr>
	<br>
	<br>
	<h2>Food Products</h2>
	<br>
	<br>
	<%
	FoodProductDao dao = new FoodProductDao();
	List<FoodProduct> food = dao.displayAll();
	%>
	<table border="2px solid">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Type</td>
			<td>About</td>
			<td>Availability</td>
			<td>Price</td>
			<td>Remove</td>

		</tr>

		<%
		for (FoodProduct user : food) {
		%>
		<tr>

			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getType()%></td>
			<td><%=user.getAbout()%></td>
			<td><%=user.getAvailability()%></td>
			<td><%=user.getPrice()%></td>
			<td><a href="deletefood?id=<%=user.getId()%>"><button>Remove</button></a></td>

		</tr>
		<%
		}
		%>
	</table>



</body>
</html>