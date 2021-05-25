<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.online.util.UtilConstants"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ViewProfile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body> 
<jsp:include page="Header.jsp"></jsp:include>
  <%String role=(String)session.getAttribute(UtilConstants._ROLE); %>
  <%if(role.equalsIgnoreCase(UtilConstants._ADMIN)) {%>
   <jsp:include page="AdminMenu.jsp"></jsp:include><br/>
   <%} else if(role.equalsIgnoreCase(UtilConstants._USER)){
    %>
   <jsp:include page="UserMenu.jsp"></jsp:include><br/>
  
  <% } %>
  
   <% if(request.getAttribute("status")!=null)
					  {%>
                           <center> <strong><font color=red><%=request.getAttribute("status")%></font></strong>
                           
                          
                      <%}%></center> 
 	
			<table align="center" border="1" bgcolor="FFFFFF" width="60%"
				cellpadding="">
				<caption>
					<h3>
						View user profile
					</h3>
				</caption>
				<tr bgcolor="FFAAD4">
					
				</tr>
				<tr>
					<th>
						Full Name
					</th>
					
					<th>
						DOB
					</th>
					<th>
						EMAIL
					</th>
					<th>
						GENDER
					</th>
					<th>
						Phone
					</th>
					<th>
						Login Name
					</th>
					<th>
						Password
					</th>
					<th>
						street
					</th>
					<th>
						city
					</th>
					<th>
						state
					</th>
					<th>
						country
					</th>
					<th>
						pin
					</th>
					
					
				</tr>
				<c:if test="${not empty profile}">
					<c:forEach var="pro" items="${profile}">


						<tr>
							<td align="center">
								${pro.fullname}
							</td>
							
							<td align="center">
								${pro.dob}

							</td>
							<td align="center">
								${pro.email}

							</td>

							<td align="center">
								${pro.gender}

							</td>
							<td align="center">
								${pro.phone}
									

							</td>
							<td align="center">
								${pro.username}
							</td>
							<td align="center">
								${pro.password}

							</td>
							<td align="center">
								${pro.street}
							</td>
							<td align="center">
								${pro.city}
							</td>
							<td align="center">
								${pro.state}
							</td>
							<td align="center">
								${pro.country}
							</td>
							<td align="center">
								${pro.pin}
							</td>
						</tr>

					</c:forEach>
				</c:if>

			</table>
			
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<jsp:include page="Footer.jsp"></jsp:include>
		</html>
