<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Items</title>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Rubik:400,700'>
<link rel="stylesheet" href="./style1.css">

</head>
<body>
	<!-- partial:index.partial.html -->
	<div class="login-form">
		<form action="additems" method="post">
			<h1>Add Items</h1>
			<div class="content">
				<div class="input-field">
					<input type="number" placeholder="Product ID" name="pid">
				</div>
				<div class="input-field">
					<input type="number" placeholder="Quantity" name="quantity">
				</div>

			</div>
			<div class="action">
				<button>Add Item</button><br><br>
				<a href="order.jsp">Back</a>

			</div>
		</form>
	</div>
	
	<!-- partial -->
	<script src="./script.js"></script>

</body>
</html>
