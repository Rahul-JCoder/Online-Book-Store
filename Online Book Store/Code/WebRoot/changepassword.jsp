<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.online.util.UtilConstants"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changepassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script language="JavaScript" src="js/myscripts.js" type="text/javascript"></script>
	 <script type="text/javascript" src="js/form_validation.js"> </script>
  </head>
  
  <body>
 &gt;<jsp:include page="Header.jsp"></jsp:include>
  <%String role=(String)session.getAttribute(UtilConstants._ROLE); %>
  <%if(role.equalsIgnoreCase(UtilConstants._ADMIN)) {%>
   <jsp:include page="AdminMenu.jsp"></jsp:include><br/>
   <%} else if(role.equalsIgnoreCase(UtilConstants._USER)){
    %>
   <jsp:include page="UserMenu.jsp"></jsp:include><br/>
  
  <% }  %>
  
   <% if(request.getAttribute("status")!=null)
					  {%>
                           <center> <strong><font color=red><%=request.getAttribute("status")%></font></strong>
                           
                          
                      <%}%></center> 
 <br/>
 <br/> 
 <form method="post" action="./ChangePasswordAction" name="form1">
 <input type="hidden" value="<%=role %>" name="role">
 <center><h3>ChangepasswordForm</h3></center>
       <br/>
       <table border="0" align="center">
<tr>
					<td><span class=Title>
					 <font color="black"><b> Login Name</b></font>
					</span></td>
					<td>
						<input type="text" name="username" value="<%=session.getAttribute(UtilConstants._UNAME) %>" readonly />					</td>
				</tr>
				<tr>
					<td><span class=Title>
					 <font color="black"><b> Old Password</b></font>
					</span></td>
					<td>
						<input type="password" name="oldpassword" />					</td>
				</tr>
				<tr>
					<td><span class=Title>
					  <font color="black"><b>New Password</b></font>
					</span></td>
					<td>
						<input type="password" name="newpassword" />					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center"><strong>
						  <input type="submit" name="Submit" value="Change" />
						</strong></div>				  </td>
				</tr>
			</table>
			</form>
			</body>
			<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("form1");
  
  
   frmvalidator.addValidation("oldpassword","req","Please enter your oldPassword");
   frmvalidator.addValidation("newpassword","req","Please enter your newPassword");
   
     </script>
     <br/>
     <br/>
     <br/>
     <br/>
  <jsp:include page="Footer.jsp"></jsp:include>
			</html>
