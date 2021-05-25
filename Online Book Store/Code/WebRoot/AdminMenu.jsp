<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8" />
		<title>Style 01 (Orange Red) - Menu by Apycom.com</title>
		<link type="text/css" href="menu.css" rel="stylesheet" />
		<script type="text/javascript" src="jquery.js">
</script>
		<script type="text/javascript" src="menu.js">
</script>
	</head>
	<body bgcolor="pink">

		<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	
}

div#menu {
	margin: 5px auto;
}

div#copyright {
	font: 11px 'Trebuchet MS';
	color: #fff;
	text-indent: 30px;
	padding: 40px 0 0 0;
}

div#copyright a {
	color: #ff4500;
}

div#copyright a:hover {
	color: #fff;
}
</style>

		<div id="menu">
			<ul class="menu">
				<li>
					<a href="#"><span>Home</span>
					</a>
				</li>
				<li>
					<a href="#" class="parent"><span>Category</span>
					</a>
					<ul>
						<li>
							<a href="./AddCategory.jsp"><span>Add Category</span>
							</a>

						</li>
						<li>
							<a href="SearchCategoryAction?path=./ViewCategories.jsp" ><span>View Category</span>
							</a>

						</li>
						
					</ul>

				</li>
				
				<li>
					<a href="#" class="parent"><span>Books</span>
					</a>
					<ul>
					
						<li>
							<a href="./SearchCategoryAction?path=./AddBookInfo.jsp"><span>AddBooks</span>
							</a>
						</li>
						   <li><a href="./ViewBookAction"><span>View&DeleteBooks</span></a></li>
						<li>
							<a href="./UpdateBookAction"><span>UpdateBook</span>
							</a>
						</li>
						
					</ul>
				</li>
				
				<li>
					<a href="./ViewCustomerOrders"><span>CustomerOrders</span>
					</a>
					<ul>
						<li>
							<a href="./ViewCustomerOrders"><span>ViewCustomerOrders</span>
							</a>
						</li>
					</ul>
					
					
				</li>
				<li>
					<a href="./ViewCustomerOrders" class="parent"><span>Customers</span>
					</a>
					<ul>
						<li>
							<a href="./ViewProfile?path=/ViewUsers.jsp"><span>ViewAllCustomers</span>
							</a>
						</li>
						<li>
							<a href="./ViewFeedback.jsp"><span>ViewAllFeedBacks</span>
							</a>
						</li>
					</ul>
				</li>
				<li>
					<a href="./changepassword.jsp"><span>ChangePassword</span>
					</a>
				</li>
				
				<li>
					<a href="./ViewCustomerOrders?type=r"><span>Order Reports</span>
					</a>
				</li>
				
				
				<li class="last">
					<a href="./LogoutAction"><span>Logout</span>
					</a>
				</li>
			</ul>
		</div>

		<div id="copyright">
			<a href="http://apycom.com/"></a>
		</div>



	</body>
</html>