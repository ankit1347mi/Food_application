<%@page import="java.util.ArrayList"%>
<%@page import="com.ty.food_application_hibernate.dto.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.food_application_hibernate.dao.ItemDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
*{
background-image: url("https://cdn.pixabay.com/photo/2023/09/29/12/38/winter-8283735_640.jpg");
}
.anc {
	align-content: center;
	color: black;
	padding: 15px 25px;
	text-decoration: none;
	background-color:black;
}


</style>
</head>
<body>
	<a href="additems.jsp" class="anc">Add Items</a>
	<a href="shome.jsp" class="anc">Back</a>
	<br>
	<br>
	<hr>
	<br>
	<br>

	<%
	ItemDao dao = new ItemDao();
	List<Item> users = dao.displayAllItem();
	%>
	<table border="2px solid">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Product ID</td>
			<td>Type</td>
			<td>Quantity</td>
			<td>Price</td>
			<td>Remove</td>



		</tr>

		<%
		List<Integer> list = new ArrayList<Integer>();
		for (Item user : users) {
			list.add(user.getId());
			
		%>
		<tr>

			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getProductId()%></td>
			<td><%=user.getType()%></td>
			<td><%=user.getQuantity()%></td>
			<td><%=user.getPrice()%></td>
			<td><a href="deleteitem?id=<%=user.getId()%>"><button>Remove</button></a></td>

		</tr>
		<%
		}
		request.setAttribute("list", list);
		%>
	</table>
	<br><br>
	<form action="createorder" method="post">
	<input type="text" name="cname" placeholder="Enter the customer Number "><br><br>
	<input type="text" name="item_id" placeholder="Enter the Item Id with , seperated">
	<br><br>
		<input type="submit" value="Add Items to Order">

	</form>

</body>
</html>