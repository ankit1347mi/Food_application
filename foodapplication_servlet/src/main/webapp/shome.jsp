<%@page import="java.util.stream.Collectors"%>
<%@page import="com.ty.food_application_hibernate.dto.FoodOrder"%>
<%@page import="com.ty.food_application_hibernate.dao.FoodOrderDao"%>
<%@page import="com.ty.food_application_hibernate.dto.FoodProduct"%>
<%@page import="com.ty.food_application_hibernate.dao.FoodProductDao"%>
<%@page import="com.ty.food_application_hibernate.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.food_application_hibernate.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Login Page</title>
<style>
body {
	color: white;
	padding-top: 20px;
	padding-left: 100px;
	background-image:
		url("https://cdn.pixabay.com/photo/2023/10/06/06/04/ai-generated-8297505_640.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.anc {
	align-content: center;
	color: white;
	padding: 15px 25px;
	text-decoration: none;
	background-color: rgba(11, 13, 12, 0.5);
}

table {
	padding: 4px;
}
</style>
</head>
<body>
	<h1>Staff Home Page</h1>
	<br>
	<br>
	<a href="order.jsp" class="anc">Take Order</a>
	<a href="customer.jsp" class="anc">Add Customer</a>
	<a href="Login.jsp" class="anc">Logout</a>
	<br>
	<br>
	<hr>
	<br>
	<br>
	<h1>Customer details</h1>
	<%
	UserDao udao = new UserDao();
	List<User> userss = udao.findAllCustomer();
	%>
	<table border="2px solid">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Phone</td>


		</tr>

		<%
		for (User user : userss) {
		%>
		<tr>

			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getPhone()%></td>


		</tr>
		<%
		}
		%>
	</table>

	<hr>
	<br>
	<br>
	<h1>Order Products Details</h1>

	<%
	FoodOrderDao dao = new FoodOrderDao();
	List<FoodOrder> users = dao.displayAllFoodOrder();
	users = (List<FoodOrder>) users.stream().sorted((task1, task2) -> task2.getStatus().compareTo(task1.getStatus()))
			.collect(Collectors.toList());
	%>
	<table border="2px solid">
		<tr>
			<td>Id</td>
			<td>Status</td>
			<td>Totalprice</td>
			<td>Order Creation Time</td>
			<td>Order Delivery Time</td>
			<td>CustomerName</td>
			<td>Customer Number</td>
			<td>Update Status</td>


		</tr>

		<%
		for (FoodOrder user : users) {
		%>
		<tr>

			<td><%=user.getId()%></td>
			<td><%=user.getStatus()%></td>
			<td><%=user.getTotalPrice()%></td>
			<td><%=user.getOrderCreatedTime()%></td>
			<td><%=user.getOrderDeliveryTime()%></td>
			<td><%=user.getCustomerName()%></td>
			<td><%=user.getContactNumber()%></td>
			<td><a href="updatestatus?id=<%=user.getId()%>"><button>Update</button></a></td>
		</tr>
		<%
		}
		%>
	</table>
	<hr>
	<br>
	<br>
	<h1>Food Products Details</h1>


	<%
	FoodProductDao dao1 = new FoodProductDao();
	List<FoodProduct> food = dao1.displayAll();
	%>
	<table border="2px solid">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Type</td>
			<td>Availability</td>
			<td>About</td>
			<td>Price</td>


		</tr>

		<%
		for (FoodProduct user : food) {
		%>
		<tr>

			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getType()%></td>
			<td><%=user.getAvailability()%></td>
			<td><%=user.getAbout()%></td>
			<td><%=user.getPrice()%></td>

		</tr>
		<%
		}
		%>
	</table>




</body>
</html>