<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'AddBookInfo.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script language="JavaScript" src="js/form_validation.js"
			type="text/javascript">

</script>
		<script type="text/javascript" src="js/myscripts.js">
</script>
	</head>

	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="AdminMenu.jsp"></jsp:include>

		<jsp:include page="status.jsp"></jsp:include>
		<form action="./UpdateBookSuccess" name="f1" method="post">
			<h3 align="center">
				Book Information Form 
			</h3>
			<br />
			<c:if test="${not empty bookinfo}">
			<c:forEach var="bookinfo" items="${bookinfo}">
				
			<table align="center" border="1" bgcolor="white">
				
				
				<tr>
					<th>
						isbnno :
					</th>
					<td>
						<input type="text" name="isbn"  value="${bookinfo.isbn }">
					</td>
				</tr>
				
				<tr>
					<th>
						Book Name :
					</th>
					<td>
						<input type="text" name="title" value="${bookinfo.title }">
					</td>
				</tr>
				
				<tr>
					<th>
						Book Description :
					</th>
					<td>
						<textarea rows="6" cols="15" name="description" >${bookinfo.description }</textarea>
					</td>
				</tr>
				<tr>
					<th>
						Price :
					</th>
					<td>
						<input type="text" name="price" value="${bookinfo.price }">
					</td>
				</tr>
				<tr>
					<th>
						Publisher :
					</th>
					<td>
						<input type="text" name="publisher" value="${bookinfo.publisher}">
					</td>
				</tr>
				<tr align="center">
					<td>
						<input type="submit" name="submit" value="UpdateBooksInfo">
					</td>
					<td>
						<input type="reset" name="reset" value="reset">
					</td>
				</tr>
				 </c:forEach>
                          </c:if>  
			</table>
		</form>

		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />

		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
	<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
var frmvalidator = new Validator("f1");

frmvalidator.addValidation("categoryid", "dontselect=0");
frmvalidator.addValidation("title", "req", "Please enter book title");
frmvalidator.addValidation("fname", "req", "Please enter author name");
frmvalidator.addValidation("description", "req",
		"Please enter book description");

frmvalidator.addValidation("price", "req", "Please enter price");
frmvalidator.addValidation("price", "numeric");

frmvalidator.addValidation("publisher", "req", "Please enter publisher  Name");
frmvalidator.addValidation("edition", "req", "Please enter edition");
frmvalidator.addValidation("edition", "numeric");
frmvalidator.addValidation("pages", "req", "Please enter pages");
frmvalidator.addValidation("pages", "numeric");
frmvalidator.addValidation("quantity", "req", "Please enter pages");
frmvalidator.addValidation("quantity", "numeric");

frmvalidator.addValidation("language", "dontselect=0");

frmvalidator.addValidation("image", "req", "image required");
</script>
	<link rel="stylesheet" type="text/css" href="css/scroll.css">
</html>

