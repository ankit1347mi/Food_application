<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Signup</title>
	<!-- Mobile Specific Metas -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<!-- Font-->
	<link rel="stylesheet" type="text/css" href="nunito-font.css">
	<!-- Main Style Css -->
    <link rel="stylesheet" href="style.css">
</head>
<body class="form-v9">
	<div class="page-content">
		<div class="form-v9-content" style="background-image: url('images/form-v9.jpg')">
			<form class="form-detail" action="csignup" method="post">
				<h2>Add Customer</h2>
				<div class="form-row-total">
					<div class="form-row">
						<input type="text" name="full-name" id="full-name" class="input-text" placeholder="Your Name" required>
					</div>
					<div class="form-row">
						<input type="tel" name="your-phone" id="your-email" class="input-text" placeholder="Your Phone" required >
					</div>
				</div>
				<div class="form-row-total">
					<div class="form-row">
						<input type="password" name="password" id="password" class="input-text" placeholder="Your Password" required>
					</div>
					<div class="form-row">
						<input type="password" name="comfirm-password" id="comfirm-password" class="input-text" placeholder="Confirm Password" required>
					</div>
				</div>
				<div class="form-row-last">
					<input type="submit" name="register" class="register" value="Add Customer">
				</div>
				<div class="form-row-last">
					Already have an account
					<a href="shome.jsp"></a>
				</div>
				
			</form>
		</div>
	</div>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>