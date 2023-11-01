<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.food_application_hibernate.dto.FoodOrder"%>
<%@page import="com.ty.food_application_hibernate.dao.FoodOrderDao"%>
<%@page import="com.ty.food_application_hibernate.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
* {
	background-image:
		url("https://media.istockphoto.com/id/157681198/photo/dandelion-seed.jpg?s=612x612&w=0&k=20&c=TfhCtc_Y1oSpdlL7o6yo7BTfgnD0RCy6yF1SgvQO0Jk=");
	background-repeat: no-repeat;
	background-size: cover;
}

a {
	align-content: center;
	color: black;
	padding: 15px 25px;
	text-decoration: none;
	background-color: rgba(11, 13, 12, 0.5);
	margin-left: 85%;
}
</style>

</head>
<body>
	<%
	User user = (User) request.getAttribute("user");
	long phone = user.getPhone();
	
	%>
	<a href="Login.jsp">Logout</a>
	<h1>
		<span>Welcome <%=user.getName()%></span>
	</h1>


	<br>
	<br>

	<h1>Your Order Details</h1>
	<%
	FoodOrderDao dao = new FoodOrderDao();
	List<FoodOrder> foodOrderss = dao.findFoodOrderByPhone(phone);
	foodOrderss = (List<FoodOrder>) foodOrderss.stream().sorted((task1, task2) -> task2.getStatus().compareTo(task1.getStatus()))
			.collect(Collectors.toList());
	%>

	<table border="2px solid">
		<tr>
			<td>Id</td>
			<td>Status</td>
			<td>TotalPrice</td>
			<td>CustomerName</td>
			<td>ContactNumber</td>
			<td>OrderCreatedTime</td>

		</tr>
		<tr>
			<%
			for (FoodOrder foodOrder : foodOrderss) {
			%>
		
		<tr>
			<td><%=foodOrder.getId()%></td>
			<td><%=foodOrder.getStatus()%></td>
			<td><%=foodOrder.getTotalPrice()%></td>
			<td><%=foodOrder.getCustomerName()%></td>
			<td><%=foodOrder.getContactNumber()%></td>
			<td><%=foodOrder.getOrderCreatedTime()%></td>

		</tr>
		<%
		}
		%>





	</table>






</body>
</html>